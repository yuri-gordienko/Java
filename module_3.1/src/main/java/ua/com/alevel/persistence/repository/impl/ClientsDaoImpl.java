package ua.com.alevel.persistence.repository.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.configHiber.HibernateConfig;
import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.persistence.entity.product.Clients;
import ua.com.alevel.persistence.repository.ClientsDao;

import java.util.*;

public class ClientsDaoImpl implements ClientsDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Clients clients) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(clients);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Clients clients) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(clients);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Clients clients) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(clients);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Clients> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Clients clients = session.find(Clients.class, id);
            transaction.commit();
            return Optional.of(clients);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Clients> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Clients");
            List<Clients> client = query.getResultList();
            transaction.commit();
            return client;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public void attachAccountsToClients(Clients clients, Accounts accounts) {
//        Set<Accounts> account = clients.getAccount(); // получаем сет счетов у клиента
//        account.add(accounts);    // добавляем новый счет
//        update(clients);  // обновляем табл клиентов
    }

    @Override
    public void detachAccountsFromClients(Clients clients, Accounts accounts) {
//        Set<Accounts> account = clients.getAccount();
//        account.removeIf(pup -> pup.getId().equals(accounts.getId()));
//        update(clients);
    }

    @Override
    public boolean existByEmail(String email) {
        Collection<Clients> client = findAll();
        return client.stream().anyMatch(clients -> clients.getEmail().equals(email));
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
