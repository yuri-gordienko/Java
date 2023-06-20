package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;

import java.util.Collection;

@Service
@Transactional
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {

    private final ProductVariantRepository productVariantRepository;
    private final CrudHelperService<ProductVariant, ProductVariantRepository> crudHelperService;

    public ProductVariantCrudServiceImpl(ProductVariantRepository productVariantRepository, CrudHelperService<ProductVariant, ProductVariantRepository> crudHelperService) {
        this.productVariantRepository = productVariantRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(ProductVariant entity) {
        crudHelperService.create(entity, productVariantRepository);
    }

    @Override
    public void update(ProductVariant entity) {
        crudHelperService.update(entity, productVariantRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productVariantRepository);
    }

    @Override
    public ProductVariant findById(Long id) {
        return crudHelperService.findById(id, productVariantRepository);
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productVariantRepository);
    }

    @Override
    public Collection<ProductVariant> findByProduct(Product product) {
        return productVariantRepository.findByProduct(product);
    }
}
