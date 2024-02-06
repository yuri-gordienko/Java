package yugo.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.product.ProductDto;
import yugo.data.response.DataContainer;
import yugo.facade.ProductCrudFacade;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductCrudFacade productCrudFacade;

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody ProductDto dto) {
        productCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody ProductDto dto, @PathVariable Long id) {
        productCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        productCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<ProductDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<ProductDto>>> findAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort,
            @RequestParam String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(productCrudFacade.findAll(request)));
    }
}
