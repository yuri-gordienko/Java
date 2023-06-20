package ua.com.alevel.persistence.repository.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.configHiber.HibernateConfig;
import ua.com.alevel.persistence.entity.product.Transactions;
import ua.com.alevel.persistence.repository.TransactionsDao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TransactionsDaoImpl implements TransactionsDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Transactions transactions) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(transactions);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Transactions transactions) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(transactions);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Transactions transactions) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(transactions);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Transactions> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Transactions transactions = session.find(Transactions.class, id);
            transaction.commit();
            return Optional.of(transactions);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Transactions> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Transactions");
            List<Transactions> tr = query.getResultList();
            transaction.commit();
            return tr;
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
