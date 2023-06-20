package ua.com.alevel.persistence.repository;

import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.persistence.entity.product.Clients;

public interface ClientsDao extends CrudDao<Clients> {

    void attachAccountsToClients(Clients clients, Accounts accounts);

    void detachAccountsFromClients(Clients clients, Accounts accounts);

    boolean existByEmail(String email);
}
