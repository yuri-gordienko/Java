package ua.com.alevel.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.persistence.elasticsearch.document.ProductIndex;
import ua.com.alevel.service.crud.product.ProductInfoSearchService;

import java.util.Collection;

@RestController
@RequestMapping("/api/open/products/search")
public class ProductInfoSearchController {

    private final ProductInfoSearchService productInfoSearchService;

    public ProductInfoSearchController(ProductInfoSearchService productInfoSearchService) {
        this.productInfoSearchService = productInfoSearchService;
    }

    @GetMapping
    public ResponseEntity<DataContainer<Collection<ProductIndex>>> search(@RequestParam String query) {
        return ResponseEntity.ok(new DataContainer<>(productInfoSearchService.search(query)));
    }
}
