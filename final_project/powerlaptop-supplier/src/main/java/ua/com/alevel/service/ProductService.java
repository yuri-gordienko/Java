package ua.com.alevel.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.ProductPageDto;
import ua.com.alevel.entity.Product;
import ua.com.alevel.repository.ProductRepository;

@Service
@AllArgsConstructor // конструктор для наполнения нашей базы информацией от поставщика
public class ProductService {

    private final ProductRepository productRepository;

    public ProductPageDto findAll(int page, int size) { // тащим все продукты. пагинация - принимаем страницу и размер
        Page<Product> productPage = productRepository.findAll(PageRequest.of(page, size));
        ProductPageDto dto = new ProductPageDto(); // формируем дто
        dto.setProducts(productPage.getContent());  // получаем контент
        dto.setHasNext(productPage.hasNext());  // // есть ли еще, что спрашивать, добавляем по очереди
        return dto; // возвращаем готовую дто
    }

    public Product findByCode(String code) {    // тащим продукт по коду
        return productRepository.findByCode(code);
    }

    public Long count() {   // тащим по кол-ву
        return productRepository.count();
    }
}