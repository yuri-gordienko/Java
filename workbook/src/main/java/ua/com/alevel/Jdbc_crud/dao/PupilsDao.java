package ua.com.alevel.Jdbc_crud.dao;

import ua.com.alevel.entity.Pupils;

public interface PupilsDao extends BaseDao<Pupils> {

    boolean existsByFirstNameOrLastName(String firstName, String lastName);
}
