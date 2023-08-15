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

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory(); // вызываем сешнфабрику

    @Override   // аннотация говорит что тут имплементируем абстрактный метод из Парента PupilsDao, а тот из BaseDao
    public void create(Pupils pupils) {
        Transaction transaction = null; // указываем, что работаем через транзакцию
        try // с ресурсами, потому что транзакцию нужно будет закрыватьь
            (Session session = sessionFactory.getCurrentSession()) { // получаем сессию, Хайбер сам решает какую сессию дать
            transaction = session.beginTransaction();   // начинаем транзакцию
            session.save(pupils);   // оперируем на уровне java кода, создаем объект, т.е. в save уже прописан sql запрос
            transaction.commit();   // после нужно транзакцию комитить
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());  // выводим сообщение, если получим ошибку
            rollbackTransaction(transaction);   // откатываем транзакцию в случае получения ошибки
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
            Pupils pupils = session.find(Pupils.class, id); // такой вид запроса (есть другой вариант через Query )
            transaction.commit();
            return Optional.of(pupils); // возвращаем только после комита, Optional - может быть, может не быть
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Pupils> findAll() { // нет стандартного метода, поэтому получаем через Хайбер-т квери ленгвич
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Pupils");   // пишем кверю hql
            List<Pupils> pupil = query.getResultList(); // получаем Лист объектов у нашего квери запроса
            transaction.commit(); // комитим
            return pupil;   // возвращаем объекты
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList(); // по дефолту будет возвращать пустой лист
    }

    @Override
    public boolean existByEmail(String email) {
        Collection<Pupils> pupil = findAll();
        return pupil.stream().anyMatch(pupils -> pupils.getEmail().equals(email));
    }

    // создаем глобальный метод для отката транзакции, чтоб не было дублирования кода
    // если хоть один sql запрос зафейлился, то все предыдущие должны быть отменены
    private void rollbackTransaction(Transaction transaction) { // по принципу ACID, трензакция дожна быть атомарной (откатываться в случае чего)
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
