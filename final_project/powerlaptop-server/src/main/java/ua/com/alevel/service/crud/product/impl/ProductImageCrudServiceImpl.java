package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.repository.product.ProductImageRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductImageCrudService;

import java.util.Set;

@Service
@Transactional
public class ProductImageCrudServiceImpl implements ProductImageCrudService {

    private final ProductImageRepository productImageRepository;
    private final CrudHelperService<ProductImage, ProductImageRepository> crudHelperService;

    public ProductImageCrudServiceImpl(ProductImageRepository productImageRepository, CrudHelperService<ProductImage, ProductImageRepository> crudHelperService) {
        this.productImageRepository = productImageRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(ProductImage entity) {
        crudHelperService.create(entity, productImageRepository);
    }

    @Override
    public void update(ProductImage entity) {
        crudHelperService.update(entity, productImageRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productImageRepository);
    }

    @Override
    public ProductImage findById(Long id) {
        return crudHelperService.findById(id, productImageRepository);
    }

    @Override
    public Page<ProductImage> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productImageRepository);
    }

    @Override
    public Set<ProductImage> findAllByIdIn(Set<Long> ids) {
        return productImageRepository.findAllByIdIn(ids);
    }
}
