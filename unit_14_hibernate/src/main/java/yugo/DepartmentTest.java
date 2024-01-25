package yugo;

import yugo.dao.DepartmentDao;
import yugo.dao.EmployeeDao;
import yugo.dao.impl.DepartmentDaoImpl;
import yugo.dao.impl.EmployeeDaoImpl;
import yugo.entity.Department;
import yugo.entity.Employee;

public class DepartmentTest {

    DepartmentDao departmentDao = new DepartmentDaoImpl();
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void run() {
//        createDepartment();
//        deleteDepartment();
//        attachEmployeeToDepartment();
        detachEmployeeFromDepartment();
    }

    private void createDepartment() {
        Department department = new Department();
        department.setName("Digit Marketing");
        departmentDao.create(department);
    }

    private void deleteDepartment() {
        Department department = new Department();
        department = departmentDao.findById(11L).get();
        departmentDao.delete(department);
    }

    private void attachEmployeeToDepartment() {
        Department department6 = departmentDao.findById(6L).get();
        Employee employee1 = employeeDao.findById(3L).get();
        Employee employee2 = employeeDao.findById(7L).get();
        departmentDao.attachEmployeeToDepartment(department6, employee1);
        departmentDao.attachEmployeeToDepartment(department6, employee2);
    }

    private void detachEmployeeFromDepartment() {
        Department department6 = departmentDao.findById(6L).get();
        Employee employee1 = employeeDao.findById(3L).get();
        departmentDao.detachEmployeeFromDepartment(department6, employee1);
    }
}
