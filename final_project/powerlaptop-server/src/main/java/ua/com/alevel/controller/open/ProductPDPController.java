package ua.com.alevel.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.data.dto.product.ProductPDPDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.pdp.ProductPDPFacade;

@RestController
@RequestMapping("/api/products/{id}/pdp")
public class ProductPDPController {

    private final ProductPDPFacade productPDPFacade;

    public ProductPDPController(ProductPDPFacade productPDPFacade) {
        this.productPDPFacade = productPDPFacade;
    }

    @GetMapping
    public ResponseEntity<DataContainer<ProductPDPDto>> findByProduct(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productPDPFacade.findById(id)));
    }
}