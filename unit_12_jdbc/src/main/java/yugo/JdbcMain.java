package yugo;

import yugo.dao.DepartmentDao;
import yugo.dao.EmployeeDao;
import yugo.dao.impl.DepartmentDaoImpl;
import yugo.dao.impl.EmployeeDaoImpl;
import yugo.dto.DepartmentDto;
import yugo.entity.Department;
import yugo.entity.Employee;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static yugo.util.Enum.*;

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

//        employeeDao.existByFirstNameOrLastName("Юрій", "Єфіменко");

        DepartmentDao departmentDao = new DepartmentDaoImpl();
        Department department = new Department();
        department.setName("DEV OPS");
//        departmentDao.create(department);

//        departmentDao.findAll();
//        departmentDao.findById(8L);

//        Optional<Employee> optionalEmployee = employeeDao.findById(6L);
//        if (optionalEmployee.isPresent()) {
//            Employee employee1 = optionalEmployee.get();
//            departmentDao.attachEmployeeToDepartment(4L, employee1.getId());
//        }

//        departmentDao.detachEmployeeToDepartment(6L, 18L);

        List<DepartmentDto> dtos = departmentDao.getDepartmentStatistics(ORDER_BY, DESC);
        dtos.forEach(System.out::println);
    }
}