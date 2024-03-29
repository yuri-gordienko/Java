package yugo.service.crud;

import org.springframework.data.domain.Page;
import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.BaseEntity;

public interface CrudService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(Long id);
    E findById(Long id);
    Page<E> findAll(DataTableRequest request);
}
