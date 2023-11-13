package yugo.service;

import yugo.entity.Dep_Emp;

public class Dep_EmpService {

    DepartmentService departmentService = new DepartmentService();
    EmployeeService employeeService = new EmployeeService();

    Dep_Emp[] depEmps = new Dep_Emp[5];

    public void attachEmployeeToDepartment(String empId, String depId) {
        for (int i = 0; i < depEmps.length; i++) {
            if (depEmps[i] == null) {
                Dep_Emp depEmp = new Dep_Emp();
                depEmp.setEmpId(empId);
                depEmp.setDepId(depId);
                depEmps[i] = depEmp;
                break;
            }
        }
    }

    public void deleteEmpFromDep(String empId, String depId) {
        for (int i = 0; i < employeeService.employees.length; i++) {
            if (empId.equals(employeeService.employees[i].getId())) {
               employeeService.employees[i] = null;
                for (int i1 = 0; i1 < departmentService.departments.length; i1++) {
                    if (depId.equals(departmentService.departments[i].getId())) {
                        departmentService.departments[i] = null;
                        return;
                    }
                }
            }
        }
    }

    public Dep_Emp[] readAllDepAndEmp() {
        return depEmps;
    }

    public Dep_Emp[] getEmpByDep(String depId) {
//        for (Dep_Emp dep_emp: depEmps) {
//            if (dep_emp.getEmpId().equals(depId)) {
//                return employees;
//            }
//        }
        return null;
    }
}
