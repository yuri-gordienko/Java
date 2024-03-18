package ua.com.alevel.service.crud;

import org.springframework.data.domain.Page;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.BaseEntity;

// отвечает за операции с БД, но доступ будет иметь только Админ
public interface CrudService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    E findById(Long id);    // возвращаем энтини
    Page<E> findAll(DataTableRequest request);  // возвращаем страничку
}