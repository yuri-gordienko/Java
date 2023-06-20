package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Client;

import java.util.Collection;

public interface ClientService {

    void create(Client client);

    void update(Long id, Client client);

    Client findById(Long id);

    Collection<Client> findAll();

    void delete(Long id);
}
