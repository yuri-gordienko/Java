package ua.com.alevel.Jdbc_crud.dao;

import ua.com.alevel.Jdbc_crud.entity.Pupils;

public interface PupilsDao extends BaseDao<Pupils> {

    boolean existsByFirstNameOrLastName(String firstName, String lastName);
}
