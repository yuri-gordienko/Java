package ua.com.alevel.service.crud.product.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.exception.FieldEmptyException;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.product.ProductRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductCrudService;

import java.util.Collection;

import static ua.com.alevel.util.ExceptionUtil.*;

@Service
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductRepository productRepository;
    private final CrudHelperService<Product, ProductRepository> crudHelperService;

    public ProductCrudServiceImpl(ProductRepository productRepository, CrudHelperService<Product, ProductRepository> crudHelperService) {
        this.productRepository = productRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(Product entity) {
        isValidProduct(entity);
        crudHelperService.create(entity, productRepository);
    }

    @Override
    public void update(Product entity) {
        isValidProduct(entity);
        isValidId(entity.getId());
        crudHelperService.update(entity, productRepository);
    }

    @Override
    public void delete(Long id) {
        isValidId(id);
        crudHelperService.delete(id, productRepository);
    }

    @Override
    public Product findById(Long id) {
        isValidId(id);
        return crudHelperService.findById(id, productRepository);
    }

    @Override
    public Page<Product> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productRepository);
    }

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    private void isValidProduct(Product entity) {
        if (StringUtils.isBlank(entity.getName())) {
            throw new FieldEmptyException(PRODUCT_NAME_IS_NOT_PRESENT);
        }
        if (entity.getProductBrand() == null) {
            throw new FieldEmptyException(PRODUCT_BRAND_IS_NOT_PRESENT);
        }
    }

    private void isValidId(Long id) {
        if (id == null) {
            throw new FieldEmptyException(ENTITY_ID_IS_NOT_PRESENT);
        }
        if (id <= 0) {
            throw new FieldEmptyException(ENTITY_ID_IS_INCORRECT);
        }
    }
}
