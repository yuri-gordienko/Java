package yugo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yugo.data.dto.product.ProductPDPDto;
import yugo.data.response.DataContainer;
import yugo.facade.pdp.ProductPDPFacade;

@RestController
@RequestMapping("/products/{id}/pdp")
@AllArgsConstructor
public class ProductPDPController {

    private final ProductPDPFacade productPDPFacade;

    @GetMapping
    public ResponseEntity<DataContainer<ProductPDPDto>> findByProduct(@PathVariable  Long id) {
        return ResponseEntity.ok(new DataContainer<>(productPDPFacade.findById(id)));
    }
}
