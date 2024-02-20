package ua.com.alevel.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.ProductPageDto;
import ua.com.alevel.entity.Product;
import ua.com.alevel.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductPageDto findAll(int page, int size) {
        Page<Product> productPage = productRepository.findAll(PageRequest.of(page, size));
        ProductPageDto dto = new ProductPageDto();
        dto.setProducts(productPage.getContent());
        dto.setHasNext(productPage.hasNext());
        return dto;
    }

    public Product findByCode(String code) {
        return productRepository.findByCode(code);
    }

    public Long count() {
        return productRepository.count();
    }
}
