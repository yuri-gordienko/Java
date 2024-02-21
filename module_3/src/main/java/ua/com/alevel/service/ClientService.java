package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.bank.Client;

import java.util.Collection;

public interface ClientService {

    void create(Client client);
    void update(Long id, Client client);
    void delete(Long id);
    Client findById(Long id);
    Collection<Client> findAll();
}
