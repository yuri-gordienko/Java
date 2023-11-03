package yugo.service;

import yugo.entity.Employee;

import java.util.UUID;

public class EmployeeService {

    private Employee[] employees = new Employee[2];

    int arraySize;
    public void create(Employee employee) {
        employee.setId(generateId());
        if (arraySize == employees.length) {
            Employee[] employees2 = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                employees2[i] = employees[i];
            }
            employees = employees2;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
        arraySize++;
    }

    public void update (Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employee.getId().equals(employees[i].getId())) {
                employees[i] = employee;
            }
        }
    }

    public Employee delete(String id) {
        for (int i = 0; i < employees.length; i++) {
            if (id.equals(employees[i].getId())) {
                employees[i] = null;
            }
            i++;
        }
        return null;
    }

    public Employee readById(String id) {
        for (Employee employee : employees) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }

    public Employee[] readAll() {
        return employees;
    }

    public String generateId() {
        String id = String.valueOf(UUID.randomUUID());
        for (Employee employee : employees) {
            if (employee != null && employee.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
