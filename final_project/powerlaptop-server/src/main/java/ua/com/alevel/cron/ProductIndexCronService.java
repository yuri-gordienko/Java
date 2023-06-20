package ua.com.alevel.cron;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.elasticsearch.document.ProductIndex;
import ua.com.alevel.persistence.elasticsearch.repository.ProductIndexRepository;
import ua.com.alevel.persistence.sql.dto.ProductVariantMinDto;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProductIndexCronService {  // класс для того, чтоб БД Эластика обновлялась по определенному расписанию и закачивала инфо из SQL БД

    private final ProductVariantRepository productVariantRepository;    // необходим для вытянуть инфо для строкипоиска эластика
    private final ProductIndexRepository productIndexRepository; // необходим для вытянуть инфо для строкипоиска эластика
    private final ElasticsearchOperations elasticsearchOperations;  // ложим вытнутую инфо в эластик

    public ProductIndexCronService(
            ProductVariantRepository productVariantRepository,
            ProductIndexRepository productIndexRepository,
            ElasticsearchOperations elasticsearchOperations) {
        this.productVariantRepository = productVariantRepository;
        this.productIndexRepository = productIndexRepository;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    // метод необходим, чтоб БД Эластика наполнялась/обновлялась по расписанию
    @Scheduled(cron = "*/10 * * * * *") // @Scheduled - метод расписание, "*/10 * * * * *" - экспрешн, таймер обновления (каждые 10 сек)
    public void syncToElastic() {
        elasticsearchOperations.indexOps(ProductIndex.class).refresh();
        productIndexRepository.deleteAll();
        Collection<ProductIndex> productIndexCollection = generateProductIndices();
        productIndexRepository.saveAll(productIndexCollection);
    }

    // метод берет из БД строки, согласно запроса в поисковой строке и вываливает подходящие варианты
    private Collection<ProductIndex> generateProductIndices() { // метод возвращает строку поиска, берет в базе и выдает на фронт
        Collection<ProductIndex> productIndexCollection = new ArrayList<>();
        Collection<ProductVariantMinDto> collection = productVariantRepository.find(); // генерируем на основании продукт вариантов
        if (CollectionUtils.isNotEmpty(collection)) {
            productIndexCollection = collection
                    .stream()
                    .map(dto -> {
                        ProductIndex productIndex = new ProductIndex();
                        StringBuilder productInfo = new StringBuilder();
                        Product product = dto.getProduct();
                        if (product != null) {
                            productInfo.append(product.getName());
                            productInfo.append(", ");
                            productInfo.append(dto.getCpu());
                            productInfo.append(", ");
                            productInfo.append(dto.getColor());
                        }
                        productIndex.setProductInfo(productInfo.toString());
                        return productIndex;
                    })
                    .toList();
        }
        return productIndexCollection;
    }
}