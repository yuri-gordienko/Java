package ua.com.alevel.persistence.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.elasticsearch.document.ProductIndex;

import java.util.List;

@Repository
public interface ProductIndexRepository extends ElasticsearchRepository<ProductIndex, String> {

    List<ProductIndex> findByProductInfoContainingIgnoreCase(String query);
}
