package yugo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.product.ProductVariantDto;
import yugo.data.response.DataContainer;
import yugo.facade.crud.ProductVariantCrudFacade;
import yugo.util.WebRequestUtil;

@RestController
//@AllArgsConstructor
@RequestMapping("/product-variants")
public class ProductVariantCrudController {



    private final ProductVariantCrudFacade productVariantCrudFacade;
    public ProductVariantCrudController(ProductVariantCrudFacade productVariantCrudFacade) {
        this.productVariantCrudFacade = productVariantCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody ProductVariantDto dto) {
        productVariantCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody ProductVariantDto dto, @PathVariable Long id) {
        productVariantCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        productVariantCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<ProductVariantDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productVariantCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<ProductVariantDto>>> findAll(WebRequest webRequest) {
        DataTableRequest request = WebRequestUtil.generateDataTableRequest(webRequest);
        return ResponseEntity.ok(new DataContainer<>(productVariantCrudFacade.findAll(request)));
    }
}