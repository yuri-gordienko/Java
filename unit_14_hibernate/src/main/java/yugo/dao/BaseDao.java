package yugo.dao;

import yugo.entity.BaseEntity;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public interface BaseDao <E extends BaseEntity> {

    void create (E e);
    void update (E e);
    void delete (E e);
    Optional<E> findById(Long id);
    Collection<E> findAll() throws SQLException;
}
