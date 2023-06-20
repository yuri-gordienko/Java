package ua.com.alevel.cron;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.commons.collections4.CollectionUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Transactional
public class SyncSupplierService {  // с периодичностью будет наполнять БД продавца остатками и ценами от поставщика

    private final ProductVariantRepository productVariantRepository;

    @Value("${supplier.url}")   // команда, чтоб из проперти файла подставило указанную там переменную
    private String supplierUrl;

    public SyncSupplierService(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    //    @Scheduled(cron = "*/10 * * * * *")
    public void sync() {    // синхронизируемся с поставщиком по указанному времени
        StringBuilder queryBuilder = new StringBuilder("/products");

        RestTemplate restTemplate = new RestTemplate(); // класс с помощью которого Спринг генерирует http запрос
        // получает ответ с фронтэнда, парсит его и выдает нужную информацию
        final String url = supplierUrl + queryBuilder;  // получаем урлу
        ResponseEntity<Long> response = restTemplate.getForEntity(url + "/count", Long.class);

        Long count = 0L;    // объъект типа Лонг
        if (response.getStatusCode().is2xxSuccessful()) {   // формируем запрос, если статус 200
            count = response.getBody();
            if (count != null && count != 0) {
                boolean hasNext = true;
                int page = 0;
                int size = 100;
                while (hasNext) {
                    ResponseEntity<ProductPageDto> res = restTemplate
                            .getForEntity(
                                    url + "?page=" + page + "&size=" + size,
                                    ProductPageDto.class);
                    if (res.getStatusCode().is2xxSuccessful()) {
                        ProductPageDto body = res.getBody();

                        hasNext = body.hasNext; // пока есть куда бежать мы к этому привязываемся
                        List<ProductSync> productSyncs = body.getProducts();
                        List<String> codes = productSyncs.stream().map(ProductSync::getCode).toList();

                        List<ProductVariant> productVariants = productVariantRepository.findAllByCodeIn(codes);
                        if (CollectionUtils.isNotEmpty(productVariants)) {
                            productVariants.forEach(productVariant -> { // на каждом этапе итерации, получаем продукСинк по коду
                                ProductSync productSync = productSyncs
                                        .stream()
                                        .filter(ps -> ps.code.equals(productVariant.getCode()))
                                        .findFirst()
                                        .get();
                                BigDecimal price = productSync.getPrice().multiply(new BigDecimal("1.2"));// сделали наценку на цену поставщика
                                price = price.setScale(2, RoundingMode.CEILING); // указываем, что после запятой 2 цифры
                                productVariant.setPrice(price); // сетаем прайс
                                productVariant.setQuantity(productSync.getQuantity());  // сетаем кол-во
                            });
                        }
                        productVariantRepository.saveAll(productVariants);  // сохраняем все продукт вариант репозитории
                        ++page;
                    } else {
                        hasNext = false;
                    }
                }


            }
        }
    }

    @Getter
    @Setter
    private static class ProductPageDto {
        private List<ProductSync> products;
        private boolean hasNext;
    }

    @Getter
    @Setter
    private static class ProductSync {  // иннер класс, не нужен при получении данных с сервака как отдельный независимый класс
        private String code;
        private Integer quantity;
        private BigDecimal price;
    }
}