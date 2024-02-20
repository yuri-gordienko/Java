package ua.com.alevel.service.crud.product;

import java.util.Collection;

public interface QueryTableService {

    void save(String query);
    Collection<String> findAll();
}
