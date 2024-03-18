package yugo.service.crud.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.persistence.sql.repository.product.ProductImageRepository;
import yugo.service.crud.CrudServiceUtil;
import yugo.service.crud.product.ProductImageCrudService;

import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class ProductImageCrudServiceImpl implements ProductImageCrudService {

    private final ProductImageRepository productImageRepository;
    private final CrudServiceUtil<ProductImage, ProductImageRepository> crudServiceUtil;

    @Override
    public void create(ProductImage entity) {
        crudServiceUtil.create(entity, productImageRepository);
    }

    @Override
    public void update(ProductImage entity) {
        crudServiceUtil.update(entity, productImageRepository);
    }

    @Override
    public void delete(Long id) {
        crudServiceUtil.delete(id, productImageRepository);
    }

    @Override
    public ProductImage findById(Long id) {
        return crudServiceUtil.findById(id, productImageRepository);
    }

    @Override
    public Page<ProductImage> findAll(DataTableRequest request) {
        return crudServiceUtil.findAll(request, productImageRepository);
    }

    @Override
    public Set<ProductImage> findAllByIdIn(Set<Long> ids) {
        return productImageRepository.findAllByIdIn(ids);
    }
}
