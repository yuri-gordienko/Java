package ua.com.alevel.service.crud;

import org.springframework.data.domain.Page;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

public interface CrudHelperService<E extends BaseEntity, R extends BaseEntityRepository<E>> {

    void create(E entity, R repository);
    void update(E entity, R repository);
    void delete(Long id, R repository);
    E findById(Long id, R repository);
    Page<E> findAll(DataTableRequest request, R repository);
    void checkExists(Long id, R repository);
}
