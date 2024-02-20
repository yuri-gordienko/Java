package ua.com.alevel.service.crud.product.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.elasticsearch.document.ProductIndex;
import ua.com.alevel.persistence.elasticsearch.repository.ProductIndexRepository;
import ua.com.alevel.service.crud.product.ProductInfoSearchService;

import java.util.Collection;

@Service
public class ProductInfoSearchServiceImpl implements ProductInfoSearchService {

    private final ProductIndexRepository productIndexRepository;

    public ProductInfoSearchServiceImpl(ProductIndexRepository productIndexRepository) {
        this.productIndexRepository = productIndexRepository;
    }

    @Override
    public Collection<ProductIndex> search(String query) {
        return productIndexRepository.findByProductInfoContainingIgnoreCase(query);
    }
}
