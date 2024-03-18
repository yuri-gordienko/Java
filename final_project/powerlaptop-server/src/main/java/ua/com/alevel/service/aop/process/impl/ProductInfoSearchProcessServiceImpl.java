package ua.com.alevel.service.aop.process.impl;

import org.springframework.stereotype.Component;
import ua.com.alevel.service.aop.process.ProductInfoSearchProcessService;
import ua.com.alevel.service.crud.product.QueryTableService;

@Component
public class ProductInfoSearchProcessServiceImpl implements ProductInfoSearchProcessService {

    private final QueryTableService queryTableService;

    public ProductInfoSearchProcessServiceImpl(QueryTableService queryTableService) {
        this.queryTableService = queryTableService;
    }

    @Override
    public void saveSearchQuery(String query) {
        queryTableService.save(query);
    }
}
