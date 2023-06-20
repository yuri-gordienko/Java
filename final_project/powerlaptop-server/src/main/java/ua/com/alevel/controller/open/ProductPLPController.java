package ua.com.alevel.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.alevel.data.dto.product.ProductPLPDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.plp.ProductPLPFacade;

import java.util.Collection;

@RestController
@RequestMapping("/api/products/plp")
public class ProductPLPController {

    private final ProductPLPFacade productPLPFacade;

    public ProductPLPController(ProductPLPFacade productPLPFacade) {
        this.productPLPFacade = productPLPFacade;
    }

    @GetMapping
    public ResponseEntity<DataContainer<Collection<ProductPLPDto>>> findAll() {
        return ResponseEntity.ok(new DataContainer<>(productPLPFacade.findAll()));
    }
}
