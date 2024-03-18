package ua.com.alevel.service.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.util.PersistenceUtil;

import static ua.com.alevel.util.ExceptionUtil.ENTITY_NOT_FOUND;

@Service
@Transactional
public class CrudHelperServiceImpl<E extends BaseEntity, R extends BaseEntityRepository<E>>
        implements CrudHelperService<E, R> {

    @Override
    public void checkExists(Long id, R repository) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND);
        }
    }

    @Override
    public void create(E entity, R repository) {
        repository.save(entity);
    }

    @Override
    public void update(E entity, R repository) {
        checkExists(entity.getId(), repository);
        repository.save(entity);
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
    }
}
