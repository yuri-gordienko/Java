package ua.com.alevel.persistence.repository.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.configHiber.HibernateConfig;
import ua.com.alevel.persistence.entity.product.Accounts;
import ua.com.alevel.persistence.repository.AccountsDao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AccountsDaoImpl implements AccountsDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Accounts accounts) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(accounts);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Accounts accounts) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(accounts);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Accounts accounts) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(accounts);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Accounts> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Accounts accounts = session.find(Accounts.class, id);
            transaction.commit();
            return Optional.of(accounts);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Accounts> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Accounts");
            List<Accounts> account = query.getResultList();
            transaction.commit();
            return account;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
