package ua.com.alevel.persistence.repository;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface CrudDao<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(E e);
    Optional<E> findById(Long id);
    Collection<E> findAll();
}
