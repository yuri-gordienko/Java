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
public class SyncSupplierService {

    private final ProductVariantRepository productVariantRepository;

    @Value("${supplier.url}")
    private String supplierUrl;

    public SyncSupplierService(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

//    @Scheduled(cron = "*/10 * * * * *")
    public void sync() {
        StringBuilder queryBuilder = new StringBuilder("/products");

        RestTemplate restTemplate = new RestTemplate();
        final String url = supplierUrl + queryBuilder;
        ResponseEntity<Long> response = restTemplate.getForEntity(url + "/count", Long.class);

        Long count = 0L;
        if (response.getStatusCode().is2xxSuccessful()) {
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

                        hasNext = body.hasNext;
                        List<ProductSync> productSyncs = body.getProducts();
                        List<String> codes = productSyncs.stream().map(ProductSync::getCode).toList();

                        List<ProductVariant> productVariants = productVariantRepository.findAllByCodeIn(codes);
                        if (CollectionUtils.isNotEmpty(productVariants)) {
                            productVariants.forEach(productVariant -> {
                                ProductSync productSync = productSyncs
                                        .stream()
                                        .filter(ps -> ps.code.equals(productVariant.getCode()))
                                        .findFirst()
                                        .get();
                                BigDecimal price = productSync.getPrice().multiply(new BigDecimal("1.2"));
                                price = price.setScale(2, RoundingMode.CEILING);
                                productVariant.setPrice(price);
                                productVariant.setQuantity(productSync.getQuantity());
                            });
                        }
                        productVariantRepository.saveAll(productVariants);
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
    private static class ProductSync {
        private String code;
        private Integer quantity;
        private BigDecimal price;
    }
}
