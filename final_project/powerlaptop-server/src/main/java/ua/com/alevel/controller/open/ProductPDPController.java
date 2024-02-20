package ua.com.alevel.controller.open;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.data.dto.product.ProductPDPDto;
import ua.com.alevel.data.dto.product.ProductSearchDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.pdp.ProductPDPFacade;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.persistence.sql.type.OsType;

@RestController
@RequestMapping("/api/open/products/{id}/pdp")
public class ProductPDPController {

    private final ProductPDPFacade productPDPFacade;

    public ProductPDPController(ProductPDPFacade productPDPFacade) {
        this.productPDPFacade = productPDPFacade;
    }

    @GetMapping
    public ResponseEntity<DataContainer<ProductPDPDto>> findByProduct(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productPDPFacade.findById(id)));
    }

    @GetMapping("/variants")
    public ResponseEntity<DataContainer<Long>> findProductIdByVariants(
            @PathVariable Long id,
            @RequestParam String os,
            @RequestParam String cpu,
            @RequestParam Integer ram,
            @RequestParam Integer ssd,
            @RequestParam String color,
            @RequestParam String displayResolution,
            @RequestParam DisplayType displayType,
            @RequestParam String displaySize
    ) {
        ProductSearchDto dto = ProductSearchDto
                .builder()
                .os(OsType.findByType(os))
                .cpu(cpu)
                .ram(ram)
                .ssd(ssd)
                .color(color)
                .displayResolution(displayResolution)
                .displayType(displayType)
                .displaySize(displaySize)
                .productId(id)
                .build();
        return ResponseEntity.ok(new DataContainer<>(productPDPFacade.findProductIdByVariants(dto)));
    }
}
