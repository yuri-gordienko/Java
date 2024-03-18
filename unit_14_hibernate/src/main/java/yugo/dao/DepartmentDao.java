package yugo.dao;

import yugo.dto.DepartmentDto;
import yugo.entity.Department;
import yugo.entity.Employee;

import java.util.List;

//BaseDao реалізує стандартний CRUD, то у цьому класі ми можемо додавати не стандартні методи
public interface DepartmentDao extends BaseDao<Department> {

    void attachEmployeeToDepartment(Department department, Employee employee);
    void detachEmployeeFromDepartment(Department department, Employee employee);
//    List<DepartmentDto> getDepartmentStatistics(String orderBy, String desc);
}