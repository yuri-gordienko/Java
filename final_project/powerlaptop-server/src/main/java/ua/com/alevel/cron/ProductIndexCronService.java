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
public class ProductIndexCronService {

    private final ProductVariantRepository productVariantRepository;
    private final ProductIndexRepository productIndexRepository;
    private final ElasticsearchOperations elasticsearchOperations;

    public ProductIndexCronService(
            ProductVariantRepository productVariantRepository,
            ProductIndexRepository productIndexRepository,
            ElasticsearchOperations elasticsearchOperations) {
        this.productVariantRepository = productVariantRepository;
        this.productIndexRepository = productIndexRepository;
        this.elasticsearchOperations = elasticsearchOperations;
    }

//    @Scheduled(cron = "*/10 * * * * *")
    public void syncToElastic() {
        elasticsearchOperations.indexOps(ProductIndex.class).refresh();
        productIndexRepository.deleteAll();
        Collection<ProductIndex> productIndexCollection = generateProductIndices();
        productIndexRepository.saveAll(productIndexCollection);
    }

    private Collection<ProductIndex> generateProductIndices() {
        Collection<ProductIndex> productIndexCollection = new ArrayList<>();
        Collection<ProductVariantMinDto> collection = productVariantRepository.find();
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
