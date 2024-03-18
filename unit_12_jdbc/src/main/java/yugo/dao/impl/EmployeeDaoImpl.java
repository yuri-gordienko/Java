package yugo.dao.impl;

import yugo.connector.JdbcConnector;
import yugo.dao.EmployeeDao;
import yugo.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection = JdbcConnector.getInstance().getConnection();
    private Statement statement = JdbcConnector.getInstance().getStatement();

    private static final String UPDATE = "update employees set first_name = ?, last_name = ?, age = ? where id = 13";

//    PreparedStatement клас, який відповідає за інсерти в БД, тобто виконує void методи (create, update, delete). Цей клас
//    перетворює JAVA обʼєкт на SQL обєкт і кладе його в БД. Тобто метод приймає Джава обʼєкт, а клас PreparedStatement
//    трансформує його в обʼєкт зрозумілий для БД (тобто ми сетаємо новий тип обʼєкту в БД, через гетери з Джавової бази)
//    connection.prepareStatement - підключись.підготуй запит

//    ResultSet - стан обʼєкта, який хочемо витягнути з БД, ResultSet клас конвертує SQL обʼєкт в JAVA обʼєкт

//    в try() з ресурсами кладемо класи autoclosable, які після виконання повинні бути закритими
    @Override
    public void create(Employee employee) {
        try(PreparedStatement ps = connection.prepareStatement("insert into employees values (default, ?, ?, ?)")) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Employee employee) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = connection.prepareStatement("delete from employees where id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    реалізуємо метод через PreparedStatement, але так більше коду
//    @Override
//    public Optional<Employee> findById(Long id) {
//        try(PreparedStatement pr = connection.prepareStatement("select * from employees where id = ?")) {
//            pr.setLong(1, id);
//            ResultSet resultSet = pr.executeQuery();
//            resultSet.next();
//            return Optional.of(convertResultSetToEmployee(resultSet));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//  напряму через ResultSet
    @Override
    public Optional<Employee> findById(Long id) {
        try(ResultSet rs = statement.executeQuery("select * from employees where id = " + id)) {
            rs.next();
            return Optional.of(convertResultSetToEmployee(rs)); // в Optional вкладуємо конкретний обʼєкт
        } catch (SQLException e) {
            System.out.println(e);
        }
        return Optional.empty();    // повертаємо не null, про який не хто не здогадається, а пустий обʼєкт
    }

//    на баззі Резалтсет формуємо кверю до БД
//    rs.next() - це як for each or for для фіксованих масивів, тобто таким чином ми ітеруємося по таблиці в БД і
//    на кожному етапі етерації додаємо до масиву обʼєкт із БД (аде він у виді байтів і не четабельній, тому треба його
//    конвертувати у зрозумілий вигляд, convertResultSetToEmployee(rs) - огортаємо його конвертором
    @Override
    public Collection<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try(ResultSet rs = statement.executeQuery("select * from employees")) {
            while (rs.next()) {
                employees.add(convertResultSetToEmployee(rs));
                return employees; //повертаємо колекцію у любому випадку, а якщо вона пуста, то мене як Dao розробника не не турбує
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    формуємо новий обʼєкт employeeJava, ініцуалізуємо змінні - тобто витягуємо елементи з БД для майбутнього обʼєкту,
//    елементи тягнемо згідно назв колонок де вони розташовані(а можна і по номерам колонрок), далі вже конвертовані байти в
//    Джава елементи записуємо в Джава обʼект, тобто на основі їх робимо Джава обʼєкт
    private Employee convertResultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employeeJava = new Employee();
        Long id = resultSet.getLong("id");
        String fn = resultSet.getString("first_name");
        String ln = resultSet.getString("last_name");
        int age = resultSet.getInt("age");
        employeeJava.setId(id);
        employeeJava.setFirstName(fn);
        employeeJava.setLastName(ln);
        employeeJava.setAge(age);
        return employeeJava;
    }

//    в цьому методі ми використовуємо певну логіку, для цього потрібно вже використовувати більш складну структуру
//    PreparedStatement використовуємо, т.к потрібно ставити знаки "?" для обʼєктів, яких ми заздалегіть не знаємо, тобто
//    сетаємо параметри у базу, потім на основі цих параметров формується кверя, ітеруємося, Long count (як count = 0;) і
//    положили назву колонки (зробили нову колонку) спеціально для підрахунку, задаємо умову для boolean
    @Override
    public boolean existByFirstNameOrLastName(String firstName, String lastName) {
        try(PreparedStatement ps = connection.prepareStatement("select count(*) as count_of_employee from employees " +
                "where first_name like ? or last_name like ?")) {
        ps.setString(1, "%" + firstName + "%");
        ps.setString(2, "%" + lastName + "%");
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        Long count = resultSet.getLong("count_of_employee");
        return count > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
