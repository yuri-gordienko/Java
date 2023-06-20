package ua.com.alevel.service.impl;

import ua.com.alevel.persistence.entity.product.Clients;
import ua.com.alevel.persistence.repository.ClientsDao;
import ua.com.alevel.persistence.repository.impl.ClientsDaoImpl;
import ua.com.alevel.service.ClientsService;

import java.util.Collection;
import java.util.Optional;

public class ClientsServiceImpl implements ClientsService {

    private final ClientsDao clientsDao = new ClientsDaoImpl();

    @Override
    public boolean create(Clients clients) {
        if (!clientsDao.existByEmail(clients.getEmail())) {
            clientsDao.create(clients);
        }
        return false;
    }

    @Override
    public void update(Clients clients, Long id) {
        Optional<Clients> optionalClients = clientsDao.findById(id);
        if (optionalClients.isPresent()) {
            clients.setId(id);
            clientsDao.update(clients);
        } else {
            System.out.println("Check entered data.");
        }
    }

    @Override
    public void delete(Clients clients) {
        clientsDao.delete(clients);
    }

    @Override
    public Clients findById(Long id) {
        Optional<Clients> optionalClients = clientsDao.findById(id);
        if (optionalClients.isPresent()) {
            return clientsDao.findById(id).get();
        } else {
            throw new SecurityException("ID is incorrect, check entered data!");
        }
    }

    @Override
    public Collection<Clients> findAll() {
        return clientsDao.findAll();
    }
}