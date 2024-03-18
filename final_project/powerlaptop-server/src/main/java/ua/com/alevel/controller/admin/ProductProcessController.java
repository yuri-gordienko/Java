package ua.com.alevel.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.data.dto.product.ProductProcessDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.process.ProductProcessFacade;

@RestController
@RequestMapping("/api/private/admin/products/{id}/process")
public class ProductProcessController {

    private final ProductProcessFacade productProcessFacade;

    public ProductProcessController(ProductProcessFacade productProcessFacade) {
        this.productProcessFacade = productProcessFacade;
    }

    @PutMapping("/attach")
    public ResponseEntity<DataContainer<Boolean>> attach(@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.attach(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/detach")
    public ResponseEntity<DataContainer<Boolean>> detach(@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detach(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }
}
