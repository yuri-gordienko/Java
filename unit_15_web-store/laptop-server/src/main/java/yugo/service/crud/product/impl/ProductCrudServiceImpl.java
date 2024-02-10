package yugo.service.crud.product.impl;

import org.apache.commons.lang3.StringUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.exception.EntityNotFoundException;
import yugo.exception.FieldEmptyException;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.repository.product.ProductRepository;
import yugo.service.crud.product.ProductCrudService;
import yugo.util.IsValidFields;

import java.util.Collection;

import static yugo.util.ExceptionUtil.*;

@Service
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductRepository productRepository;
    private final IsValidFields isValidFields;

    public ProductCrudServiceImpl(ProductRepository productRepository, IsValidFields isValidFields) {
        this.productRepository = productRepository;
        this.isValidFields = isValidFields;
    }

    @Override
    public void create(Product entity) {
        isValidProduct(entity); // подгоняем реализацию метода под написанные тесты
        productRepository.save(entity);
    }

    @Override
    public void update(Product entity) {
        isValidProduct(entity);
        isValidId(entity.getId());
        productRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        isValidId(id);
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        isValidId(id);
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Override
    public Collection<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(DataTableRequest request) {
        Sort sort = request.getSort().equals("desc")
                ? Sort.by(request.getOrder()).descending() : Sort.by(request.getOrder()).ascending();
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);
        return productRepository.findAll(pageable);
//      клас PageRequest приймає (int page, int size, Sort sort)
    }

    public void isValidProduct(Product entity) {   // метод для проверки метода в соответствии с тестами
        if (StringUtils.isBlank(entity.getName())) {
            throw new FieldEmptyException(PRODUCT_NAME_IS_NOT_PRESENT); // енамчики, что должна ответить прога на экзепшн
        }
        if (entity.getProductBrand() == null) {
            throw new FieldEmptyException(PRODUCT_BRAND_IS_NOT_PRESENT);
        }
    }

    public void isValidId(Long id) {
        if (id == null) {
            throw new FieldEmptyException(ENTITY_ID_IS_NOT_PRESENT);
        }
        if (id <= 0) {
            throw new FieldEmptyException(ENTITY_ID_IS_INCORRECT);
        }
    }

    public void checkExist(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND);
        }
    }
}
