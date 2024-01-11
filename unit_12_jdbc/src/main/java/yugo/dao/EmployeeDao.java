package yugo.dao;

import yugo.entity.Employee;

//BaseDao реалізує стандартний CRUD, то у цьому класі ми можемо додавати не стандартні методи
public interface EmployeeDao extends BaseDao<Employee> {

    boolean existByFirstNameOrLastName(String firstName, String lastName);
}
