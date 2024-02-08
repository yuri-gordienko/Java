package yugo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import yugo.data.dto.product.ProductProcessDto;
import yugo.data.response.DataContainer;
import yugo.facade.process.ProductProcessFacade;

@RestController
@RequestMapping("products/{id}/process")
@AllArgsConstructor
public class ProductProcessController {

    private final ProductProcessFacade productProcessFacade;

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
