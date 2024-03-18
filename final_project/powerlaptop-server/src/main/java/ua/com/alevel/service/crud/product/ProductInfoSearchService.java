package ua.com.alevel.service.crud.product;

import ua.com.alevel.persistence.elasticsearch.document.ProductIndex;

import java.util.Collection;

public interface ProductInfoSearchService {

    Collection<ProductIndex> search(String query);
}
