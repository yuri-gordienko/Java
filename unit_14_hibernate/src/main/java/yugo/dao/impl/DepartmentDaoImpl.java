package yugo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import yugo.config.HibernateConfig;
import yugo.dao.DepartmentDao;

import yugo.datatable.DatatableRequest;
import yugo.datatable.DatatableResponse;

import yugo.entity.Department;
import yugo.entity.Employee;

import java.sql.SQLException;

import java.util.*;

public class DepartmentDaoImpl implements DepartmentDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

    @Override
    public void create(Department department) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Department department) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Department department) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Department> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Department department = session.find(Department.class, id);
            transaction.commit();
            return Optional.of(department);
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Department> findAll() throws SQLException {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Department");
            List <Department> departments = query.getResultList();
            transaction.commit();
            return departments;
        } catch (Exception e) {
            System.out.println("e = " + e);
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public void attachEmployeeToDepartment(Department department, Employee employee) {
//  отримуємо Сет працівників у класа Department (у департамента отримали список працівників, який йому надали при
//  створені таблиці та звʼязку private Set<Employee> employees = new HashSet<>();)
//  до нас прилітають обʼєкти (Department department, Employee employee),
//  Set<Employee> employees = department.getEmployees() - створили Сет працівників з тих, що взяли у Департамента, тобто
//  Hibernate дозавантажив працівників sql запитом
//  у цей список додаємо працівників, які нам прилетіли
//  оновлюємо департамент
        Set<Employee> employees = department.getEmployees();
        employees.add(employee);
        update(department);
    }

    @Override
    public void detachEmployeeFromDepartment(Department department, Employee employee) {
        Set<Employee> employees = department.getEmployees();
        employees.removeIf(emp -> emp.getId().equals(employee.getId()));
        update(department);
    }

    @Override
    public DatatableResponse<Department> findAllItems(DatatableRequest request) {
        return null;
    }
}
