package ua.com.alevel.service.crud.product.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.elasticsearch.document.QueryTable;
import ua.com.alevel.persistence.elasticsearch.repository.QueryTableRepository;
import ua.com.alevel.service.crud.product.QueryTableService;

import java.util.Collection;

@Service
public class QueryTableServiceImpl implements QueryTableService {

    private final QueryTableRepository queryTableRepository;

    public QueryTableServiceImpl(QueryTableRepository queryTableRepository) {
        this.queryTableRepository = queryTableRepository;
        queryTableRepository.deleteAll();
    }

    @Override
    public void save(String query) {
        if (StringUtils.isNotBlank(query) && !queryTableRepository.existsByQueryInfo(query)) {
            QueryTable queryTable = new QueryTable();
            queryTable.setQueryInfo(query);
            queryTableRepository.save(queryTable);
        }
    }

    @Override
    public Collection<String> findAll() {
        return queryTableRepository
                .findAll(PageRequest.of(0, 10000))
                .getContent()
                .stream()
                .map(QueryTable::getQueryInfo)
                .toList();
    }
}
