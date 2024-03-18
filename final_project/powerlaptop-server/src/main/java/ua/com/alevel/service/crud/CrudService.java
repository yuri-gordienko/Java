package ua.com.alevel.service.crud;

import org.springframework.data.domain.Page;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.BaseEntity;

public interface CrudService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    E findById(Long id);
    Page<E> findAll(DataTableRequest request);
}
