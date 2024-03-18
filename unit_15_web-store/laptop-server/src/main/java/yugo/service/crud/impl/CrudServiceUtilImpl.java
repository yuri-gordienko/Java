package yugo.service.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.exception.EntityNotFoundException;
import yugo.persistence.sql.entity.BaseEntity;
import yugo.persistence.sql.repository.BaseEntityRepository;
import yugo.service.crud.CrudServiceUtil;
import yugo.util.PersistenceUtil;

@Service
@Transactional
public class CrudServiceUtilImpl<E extends BaseEntity, R extends BaseEntityRepository<E>>
        implements CrudServiceUtil<E, R> {

    @Override
    public void checkExists(Long id, R repository) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found");
        }
    }

    @Override
    public void create(E entity, R repository) {

        repository.save(entity);
    }

    @Override
    public void update(E entity, R repository) {
        checkExists(entity.getId(), repository);    // проверяем наличие по id;  также это проверяем в тестах
        repository.save(entity);        // также это проверяем в тестах
    }

    @Override
    public void delete(Long id, R repository) {
        checkExists(id, repository);
        repository.deleteById(id);
    }

    @Override
    public E findById(Long id, R repository) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    @Override
    public Page<E> findAll(DataTableRequest request, R repository) {
        return repository.findAll(PersistenceUtil.generatePageableByDataTableRequest(request));
        // используем утилитку из класса PersistenceUtil для решения типовых задач для метода -
        // findAll может принимать пейджейбл объъект у которого пейдж, сайз и сорт
    }
}
