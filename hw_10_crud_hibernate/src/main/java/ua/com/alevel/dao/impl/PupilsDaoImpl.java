package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.PupilsDao;
import ua.com.alevel.entity.Pupils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PupilsDaoImpl implements PupilsDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Pupils pupils) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(pupils);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Pupils pupils) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(pupils);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Pupils pupils) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(pupils);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Pupils> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Pupils pupils = session.find(Pupils.class, id);
            transaction.commit();
            return Optional.of(pupils);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Pupils> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Pupils");
            List<Pupils> pupil = query.getResultList();
            transaction.commit();
            return pupil;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean existByEmail(String email) {
        Collection<Pupils> pupil = findAll();
        return pupil.stream().anyMatch(pupils -> pupils.getEmail().equals(email));
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
