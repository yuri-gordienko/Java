package yugo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.product.ProductImageDto;
import yugo.data.response.DataContainer;
import yugo.facade.ProductImageCrudFacade;
import yugo.util.WebRequestUtil;

@RestController
@RequestMapping("/api/admin/product-images")
public class ProductImageCrudController {

    private final ProductImageCrudFacade productImageCrudFacade;

    public ProductImageCrudController(ProductImageCrudFacade productImageCrudFacade) {
        this.productImageCrudFacade = productImageCrudFacade;
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody ProductImageDto dto) {
        productImageCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody ProductImageDto dto, @PathVariable Long id) {
        productImageCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        productImageCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<ProductImageDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productImageCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<ProductImageDto>>> findAll(WebRequest webRequest) {
        // чтоб не перечислять параметры каждый отдельно как в блоке в ProductCrudController делаем утилитку
        // используем класс WebRequest, на нем вызываем WebRequestUtil (содержит в себе все те параметры), делаем проверки
        // проверяет по ключу Стринг и велью Массив стрингов т.к. в запросе если выставляются фильтры то это уже массив
        DataTableRequest request = WebRequestUtil.generateDataTableRequest(webRequest); // создаем реквест
        return ResponseEntity.ok(new DataContainer<>(productImageCrudFacade.findAll(request))); // передаем в фасад
    }
}
