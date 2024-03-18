package ua.com.alevel.persistence.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.elasticsearch.document.QueryTable;

@Repository
public interface QueryTableRepository extends ElasticsearchRepository<QueryTable, String> {

    boolean existsByQueryInfo(String query);
}
