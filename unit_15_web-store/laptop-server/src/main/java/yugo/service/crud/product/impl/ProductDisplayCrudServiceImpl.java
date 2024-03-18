package yugo.service.crud.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.product.ProductDisplay;
import yugo.persistence.sql.repository.product.ProductDisplayRepository;
import yugo.service.crud.CrudServiceUtil;
import yugo.service.crud.product.ProductDisplayCrudService;

@Service
@Transactional
@AllArgsConstructor
public class ProductDisplayCrudServiceImpl implements ProductDisplayCrudService {

    private final ProductDisplayRepository productDisplayRepository;
    private final CrudServiceUtil<ProductDisplay, ProductDisplayRepository> crudServiceUtil;

    @Override
    public void create(ProductDisplay entity) {
        crudServiceUtil.create(entity, productDisplayRepository);
    }

    @Override
    public void update(ProductDisplay entity) {
        crudServiceUtil.update(entity, productDisplayRepository);
    }

    @Override
    public void delete(Long id) {
        crudServiceUtil.delete(id, productDisplayRepository);
    }

    @Override
    public ProductDisplay findById(Long id) {
        return crudServiceUtil.findById(id, productDisplayRepository);
    }

    @Override
    public Page<ProductDisplay> findAll(DataTableRequest request) {
        return crudServiceUtil.findAll(request, productDisplayRepository);
    }
}
