package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.product.Clients;

import java.util.Collection;

public interface ClientsService {

    boolean create(Clients clients);

    void update(Clients clients, Long id);

    void delete(Clients clients);

    Clients findById(Long id);

    Collection<Clients> findAll();
}

