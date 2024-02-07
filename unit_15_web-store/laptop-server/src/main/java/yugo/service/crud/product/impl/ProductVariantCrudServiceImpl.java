package yugo.service.crud.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.persistence.sql.repository.product.ProductVariantRepository;
import yugo.service.crud.product.ProductVariantCrudService;
import yugo.util.IsValidFields;
import yugo.util.PersistenceUtil;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {

    private final ProductVariantRepository productVariantRepository;
    private final IsValidFields isValidFields;

    @Override
    public void create(ProductVariant entity) {
        productVariantRepository.save(entity);
    }

    @Override
    public void update(ProductVariant entity) {
        isValidFields.isValidId(entity.getId());
        productVariantRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        isValidFields.isValidId(id);
        productVariantRepository.deleteById(id);
    }

    @Override
    public ProductVariant findById(Long id) {
        isValidFields.isValidId(id);
        return productVariantRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {

        return productVariantRepository.findAll(PersistenceUtil.generatePageableByDataTableRequest(request));
    }

    @Override
    public Collection<ProductVariant> findByProduct(Product product) {
        return productVariantRepository.findByProduct(product);
    }
}
