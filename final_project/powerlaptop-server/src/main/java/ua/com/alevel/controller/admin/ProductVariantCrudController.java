package ua.com.alevel.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.product.ProductVariantDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.crud.ProductVariantCrudFacade;
import ua.com.alevel.util.WebRequestUtil;

@RestController
@RequestMapping("/api/private/admin/product-variants")
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
