package yugo;

import yugo.dao.EmployeeDao;
import yugo.dao.impl.EmployeeDaoImpl;
import yugo.entity.Employee;

import java.sql.SQLException;
import java.util.Collection;

public class JdbcMain {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello jdbc!");

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee = new Employee();
        employee.setFirstName("firstName_2");
        employee.setLastName("lName_2");
        employee.setAge(33);
//        employeeDao.create(employee);

//        employeeDao.delete(16L);

//        employeeDao.update(employee);

//        Collection<Employee> employees = employeeDao.findAll();
//        Employee employee1 = employeeDao.findById(8L);

        employeeDao.existByFirstNameOrLastName("Юрій", "Єфіменко");
    }
}