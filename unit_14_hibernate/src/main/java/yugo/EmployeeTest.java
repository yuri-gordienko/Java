package yugo;

import yugo.dao.EmployeeDao;
import yugo.dao.impl.EmployeeDaoImpl;

import yugo.datatable.DatatableRequest;
import yugo.datatable.DatatableResponse;

import yugo.entity.Employee;

import java.util.Random;

public class EmployeeTest {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void start() {
//        createEmployee();
//        findByIdEmployee();
//        updateEmployee();
//        deleteEmployee();
//        createEmployeeList();
        dataTable();
    }

    Employee employee = new Employee();

    private void createEmployee() {
        employee.setFirstName("name_1");
        employee.setLastName("surname_1");
        employee.setAge(34);
        employee.setEmail("e@mail.com");
        employeeDao.create(employee);
    }

    private void findByIdEmployee() {
        employee = employeeDao.findById(1L).get();
        System.out.println("employee = " + employee);
    }

    private void updateEmployee() {
        employee = employeeDao.findById(1L).get();
        System.out.println("employee = " + employee);

        employee.setFirstName("name_1.2");
        employee.setLastName("surname_1.2");
        employeeDao.update(employee);
    }

    private void deleteEmployee() {
        employeeDao.delete(employee);
    }

    private void createEmployeeList() {
        for (int i = 0; i < 1000; i++) {
            employee.setFirstName("first_name " + i);
            employee.setLastName("last_name " + i);
            employee.setAge(new Random().nextInt(18, 60));
            employee.setEmail("email " + i + "@mail.com");

            employeeDao.create(employee);
        }
    }

    public void dataTable() {
        DatatableRequest dataTableRequest = new DatatableRequest();
        dataTableRequest.setPage(3);
        dataTableRequest.setSize(10);
        dataTableRequest.setOrderBy("asc");
        dataTableRequest.setSortBy("email");
        DatatableResponse<Employee> response = employeeDao.findAllItems(dataTableRequest);
        for (Employee item : response.getItems()) {
            System.out.println("item = " + item);
        }
    }
}
