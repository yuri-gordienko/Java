package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.ElectivesDao;
import ua.com.alevel.dto.ElectivesDto;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.entity.Pupils;

import java.util.*;

public class ElectivesDaoImpl implements ElectivesDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    private static final String FIND_ALL_ELECTIVES_STATISTICS_DESC = "select e.id, e.name, count(el_id) as pupils_count " +
            "from electives as e join relation_table as rep on e.id = rep.el_id group by e.id order by pupils_count desc";

    @Override
    public void create(Electives electives) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(electives);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Electives electives) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(electives);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Electives electives) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(electives);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Electives> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Electives elective = session.find(Electives.class, id);
            transaction.commit();
            return Optional.of(elective);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Electives> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Electives");
            List<Electives> electives = query.getResultList();
            transaction.commit();
            return electives;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public void attachPupilsToElectives(Electives electives, Pupils pupils) {
        Set<Pupils> pupil = electives.getPupil();   // получаем коллекцию учеников у факультатива
        pupil.add(pupils);  // в этот список учеников добавляем ученика
        update(electives);  // обновляем факультатив, включает в себя 2 sql запроса: update electives and insert pupils
    }

    @Override
    public void detachPupilsToElectives(Electives electives, Pupils pupils) {
        Set<Pupils> pupil = electives.getPupil();
        pupil.removeIf(pup -> pup.getId().equals(pupils.getId()));
        update(electives);
    }

    @Override
    public Collection<ElectivesDto> findElectivesStatistics() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(FIND_ALL_ELECTIVES_STATISTICS_DESC);
            List<ElectivesDto> electivesDtoList = query.getResultList();
            transaction.commit();
            return electivesDtoList;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean existByName(String name) {
        Collection<Electives> elective = findAll();
        return elective.stream().anyMatch(electives -> electives.getName().equals(name));
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
