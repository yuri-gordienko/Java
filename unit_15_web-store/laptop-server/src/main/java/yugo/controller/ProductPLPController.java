package yugo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yugo.data.dto.product.ProductPLPDto;
import yugo.data.response.DataContainer;
import yugo.facade.plp.ProductPLPFaсade;

import java.util.Collection;

@RestController
@RequestMapping("/products/plp")
@AllArgsConstructor
public class ProductPLPController {

    private final ProductPLPFaсade productPLPFaсade;

    @GetMapping
    public ResponseEntity<DataContainer<Collection<ProductPLPDto>>> findAll() {
        return ResponseEntity.ok(new DataContainer<>(productPLPFaсade.findAll()));
    }
}
