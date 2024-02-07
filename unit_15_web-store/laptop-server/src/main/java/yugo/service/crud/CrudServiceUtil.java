//package yugo.service.crud;
//
//import org.springframework.data.domain.Page;
//import yugo.data.datatable.DataTableRequest;
//import yugo.persistence.sql.entity.BaseEntity;
//import yugo.persistence.sql.repository.BaseEntityRepository;
//
//public interface CrudServiceUtil<E extends BaseEntity, R extends BaseEntityRepository<E>> {
//
//    void create(E entity, R repository);
//    void update(E entity, R repository);
//    void delete(Long id, R repository);
//    E findById(Long id, R repository);
//    Page<E> findAll(DataTableRequest request, R repository);
//    void checkExists(Long id, R repository);
//}
