package ua.com.alevel.dao;

import ua.com.alevel.entity.Pupils;

public interface PupilsDao extends BaseDao<Pupils> {

    boolean existByEmail(String email);
}
