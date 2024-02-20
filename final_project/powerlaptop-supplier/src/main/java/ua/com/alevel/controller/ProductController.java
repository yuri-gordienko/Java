package ua.com.alevel.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.ProductPageDto;
import ua.com.alevel.entity.Product;
import ua.com.alevel.service.ProductService;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ProductPageDto> findAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(productService.findAll(page, size));
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> findByCode(@PathVariable String code) {
        return ResponseEntity.ok(productService.findByCode(code));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(productService.count());
    }
}
