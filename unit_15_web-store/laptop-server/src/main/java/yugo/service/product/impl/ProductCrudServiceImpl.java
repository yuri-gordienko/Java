package yugo.service.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yugo.data.datatable.DataTableRequest;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.repository.product.ProductRepository;
import yugo.service.product.ProductCrudService;

@Service
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductRepository productRepository;

    public ProductCrudServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public void create(Product product) {

        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        checkExist(product.getId());
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        checkExist(id);
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Page<Product> findAll(DataTableRequest request) {
        Sort sort = request.getSort().equals("desc")
                ? Sort.by(request.getOrder()).descending() : Sort.by(request.getOrder()).ascending();
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);
        return productRepository.findAll(pageable);
//      клас PageRequest приймає (int page, int size, Sort sort)
    }

    private void checkExist(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
    }
}
