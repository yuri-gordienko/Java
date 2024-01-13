package yugo;

import yugo.config.HibernateConfig;
import yugo.dao.EmployeeDao;
import yugo.dao.impl.EmployeeDaoImpl;
import yugo.entity.Employee;

public class HibernateMain {
    public static void main(String[] args) {

        System.out.println("Hello hibernate!");
//        HibernateConfig hibernateConfig = HibernateConfig.getInstance();

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setFirstName("name_1");
        employee.setLastName("surname_1");
        employee.setAge(34);
        employee.setEmail("e@mail.com");
//        employeeDao.create(employee);

        employee = employeeDao.findById(1L).get();
        System.out.println("employee = " + employee);

//        employee.setFirstName("name_1.2");
//        employee.setLastName("surname_1.2");
//        employeeDao.update(employee);

        employeeDao.delete(employee);

    }
}