package yugo.controller;

import yugo.entity.Department;
import yugo.entity.Employee;
import yugo.service.DepartmentService;
import yugo.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompanyController {

    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();

    public void start() throws IOException {
        System.out.println("\nCompany Database.");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String select;
        menu();
        while ((select = bufferedReader.readLine()) != null) {
            crud(bufferedReader, select);
        }
    }

    private void menu() {
        System.out.println("\nYou can choose any action:");
        System.out.println("Create employee                  ->  1");
        System.out.println("Update employee                  ->  2");
        System.out.println("Delete employee                  ->  3");
        System.out.println("Find employee by id              ->  4");
        System.out.println("Find all employees               ->  5\n");
        System.out.println("Create department                ->  6");
        System.out.println("Update department                ->  7");
        System.out.println("Delete department                ->  8");
        System.out.println("Find department by id            ->  9");
        System.out.println("Find all departments             -> 10\n");
        System.out.println("Attach employee to department    -> 11");
        System.out.println("Detach employee to department    -> 12");
        System.out.println("Find employee by department      -> 13");
        System.out.println("Find department by employee      -> 14");
        System.out.println("Exit                             ->  0");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> createEmployee(reader);
            case "2" -> updateEmployee(reader);
            case "3" -> deleteEmployee(reader);
            case "4" -> readByIdEmployee(reader);
            case "5" -> readAllEmployees();

            case "6" -> createDepartment(reader);
            case "7" -> updateDepartment(reader);
            case "8" -> deleteDepartment(reader);
            case "9" -> readByIdDepartment(reader);
            case "10" -> readAllDepartments();

            case "11" -> attach(reader);
            case "12" -> detach(reader);

            case "13" -> readEmployeesByDepartment(reader);
            case "14" -> readDepartmentByEmployees(reader);

            case "0" -> exit();
        }
        menu();
    }

    private void createEmployee(BufferedReader reader) throws IOException {
        Employee employee = new Employee();

        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter surname:");
        String surname = reader.readLine();
        System.out.println("Enter age:");
        String age = reader.readLine();
        System.out.println("Enter e-mail:");
        String email = reader.readLine();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setAge(Integer.parseInt(age));
        employee.setEmail(email);
        employeeService.create(employee);
    }

    private void updateEmployee(BufferedReader reader) throws IOException {
        System.out.println("Enter ID:");
        String id = reader.readLine();
        Employee employee = employeeService.readById(id);

        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter surname:");
        String surname = reader.readLine();
        System.out.println("Enter age:");
        String age = reader.readLine();
        System.out.println("Enter e-mail:");
        String email = reader.readLine();
        employee.setName(id);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setAge(Integer.parseInt(age));
        employee.setEmail(email);
        employeeService.update(employee);
    }

    private void deleteEmployee(BufferedReader reader) throws IOException {
        System.out.println("Enter ID");
        String id = reader.readLine();
        employeeService.delete(id);
    }

    private void readByIdEmployee(BufferedReader reader) throws IOException {
        System.out.println("Enter ID:");
        String id = reader.readLine();
        Employee employee = employeeService.readById(id);
        System.out.println("Employee be id - " + employee + "\n");
    }

    private void readAllEmployees() {
        Employee[] employees = employeeService.readAll();
        for (Employee employee : employees) {
            System.out.println("- " + employee);
        }
    }

    private void createDepartment(BufferedReader reader) throws IOException {
        Department department = new Department();

        System.out.println("Enter Department name:");
        String nameDep = reader.readLine();
        department.setName(nameDep);
        departmentService.createDep(department);
    }

    private void updateDepartment(BufferedReader reader) throws IOException {
        System.out.println("Enter ID: ");
        String id = reader.readLine();
        Department department = departmentService.readByIdDep(id);

        System.out.println("Enter Department name:");
        String nameDep = reader.readLine();
        department.setName(nameDep);
        departmentService.updateDep(department);
    }

    private void deleteDepartment(BufferedReader reader) throws IOException {
        System.out.println("Enter ID: ");
        String id = reader.readLine();
        departmentService.deleteDep(id);
    }

    private void readByIdDepartment(BufferedReader reader) throws IOException {
        System.out.println("Enter ID: ");
        String id = reader.readLine();
        Department department = departmentService.readByIdDep(id);
        System.out.println("Dep by id - " + department);
    }

    private void readAllDepartments() {
        Department[] department = departmentService.readAllDep();
        for (Department department1 : department) {
            System.out.println("new dep - " + department1);
        }
    }

    private void attach(BufferedReader reader) {

    }

    private void detach(BufferedReader reader) {

    }

    private void readEmployeesByDepartment(BufferedReader reader) {

    }

    private void readDepartmentByEmployees(BufferedReader reader) {

    }

    private void exit() {
        System.out.println("Good bye!");
        System.exit(0);
    }
}
