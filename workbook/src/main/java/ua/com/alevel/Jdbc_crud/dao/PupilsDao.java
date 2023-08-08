package ua.com.alevel.Jdbc_crud.dao;

import ua.com.alevel.Jdbc_crud.entity.Pupils;

public interface PupilsDao extends BaseDao<Pupils> { // BaseDao параметризируем <Pupils>
    // теперь в этом классе CRUD методы не нужны, т.к. они в BaseDao, а BaseDao знает что это Pupils, т.к.  параметризирован

    boolean existsByFirstNameOrLastName(String firstName, String lastName);
}
