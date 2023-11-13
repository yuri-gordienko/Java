package yugo.service;

import yugo.entity.Department;

import java.util.UUID;

public class DepartmentService {

    public Department[] departments = new Department[2];

    int arrayDepsize;

    public DepartmentService() {
    }

    public void createDep(Department department) {
//        department.setName(String.valueOf(PYTHON));
//        department.setName(String.valueOf(JAVA));
//        department.setName(String.valueOf(FRONT_END));

        department.setId(generateDepId());

        if (arrayDepsize == departments.length) {
            Department[] addDepartment = new Department[departments.length * 2];
            for (int i = 0; i < departments.length; i++) {
                addDepartment[i] = departments[i];
            }
            departments = addDepartment;
        }
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departments[i] = department;
                break;
            }
        }
        arrayDepsize++;
    }

    public void updateDep(Department department) {
        for (int i = 0; i < departments.length; i++) {
            if (department.getId().equals(departments[i].getId())) {
                departments[i] = department;
            }
        }
    }

    public Department deleteDep(String id) {
        for (int i = 0; i < departments.length; i++) {
            if (id.equals(departments[i].getId())) {
                departments[i] = null;
            }
            i++;
        }
        return null;
    }

    public Department readByIdDep(String id) {
        for (Department department : departments) {
            if (id.equals(department.getId())) {
                return department;
            }
        }
        return null;
    }

    public Department[] readAllDep() {
        return departments;
    }

    public String generateDepId() {
        String id = String.valueOf(UUID.randomUUID());
        for (Department department : departments) {
            if (department != null && id.equals(department.getId())) {
                generateDepId();
            }
        }
        return id;
    }
}
