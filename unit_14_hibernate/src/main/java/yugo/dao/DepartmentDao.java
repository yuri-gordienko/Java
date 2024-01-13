package yugo.dao;

import yugo.dto.DepartmentDto;
import yugo.entity.Department;

import java.util.List;

//BaseDao реалізує стандартний CRUD, то у цьому класі ми можемо додавати не стандартні методи
public interface DepartmentDao extends BaseDao<Department> {

    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
    List<DepartmentDto> getDepartmentStatistics(String orderBy, String desc);
}