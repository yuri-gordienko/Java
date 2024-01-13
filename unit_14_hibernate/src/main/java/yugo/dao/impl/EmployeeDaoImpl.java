package yugo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import yugo.config.HibernateConfig;
import yugo.dao.EmployeeDao;
import yugo.entity.Employee;

import java.sql.SQLException;
import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao {

//    створюємо змінну для створення сесій. в Hibernate всі операціі проходять в рамках транзакції. Виконується
//    ACID Принцип А - якщо в рамках однієї транзакції хоч один іql запит зафейлился, то транзакція не може бути
//    виконаною, вона відкатується до дотранзакційного стану, не може бути проміжного стану
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

//    щоб не було повторення коду, робимо універсальний метод для відкату транзакції у випадку помилки
    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

    @Override
    public void create(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) { // getCurrentSession - Hibernate вірішує яку сесію нам надати
            transaction = session.beginTransaction();   // транзакцію завжди потрібно починати
            session.save(employee);
            transaction.commit();   // транзакцію потрібно обовʼязково зберігати
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            transaction.commit();
            return Optional.of(employee);
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Employee> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Employee");
            List<Employee> employees = query.getResultList();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public boolean existByFirstNameOrLastName(String firstName, String lastName) {
        return false;
    }
}
