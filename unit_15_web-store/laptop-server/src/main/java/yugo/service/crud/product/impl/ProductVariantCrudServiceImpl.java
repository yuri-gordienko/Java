package yugo.service.crud.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.persistence.sql.repository.product.ProductVariantRepository;
import yugo.service.crud.CrudServiceUtil;
import yugo.service.crud.product.ProductVariantCrudService;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {

    private final ProductVariantRepository productVariantRepository;
    private final CrudServiceUtil<ProductVariant, ProductVariantRepository> crudServiceUtil;

    @Override
    public void create(ProductVariant entity) {

        crudServiceUtil.create(entity, productVariantRepository);
    }

    @Override
    public void update(ProductVariant entity) {
        crudServiceUtil.update(entity, productVariantRepository);
    }

    @Override
    public void delete(Long id) {
        crudServiceUtil.delete(id, productVariantRepository);
    }

    @Override
    public ProductVariant findById(Long id) {
        return crudServiceUtil.findById(id, productVariantRepository);
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {
        return crudServiceUtil.findAll(request, productVariantRepository);
    }

    @Override
    public Collection<ProductVariant> findByProduct(Product product) {
        return productVariantRepository.findByProduct(product);
    }
}
