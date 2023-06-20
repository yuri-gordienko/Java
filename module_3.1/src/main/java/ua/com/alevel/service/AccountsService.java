package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.persistence.entity.product.Clients;

import java.util.Collection;

public interface AccountsService {

    void create(Accounts accounts);

    void update(Accounts accounts, Long id);

    void delete(Accounts accounts);

    Accounts findById(Long id);

    Collection<Accounts> findAll();

    void exportToCsv();

//    void exportToCsv(Clients clients);
}

