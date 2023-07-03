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
@RequestMapping("/api/admin/products/{id}/process")   // чтоб не было дублирования кода {id}/process выносим на уровень
public class ProductProcessController {     // Процессмапинга контроллера

    private final ProductProcessFacade productProcessFacade;

    public ProductProcessController(ProductProcessFacade productProcessFacade) {
        this.productProcessFacade = productProcessFacade;
    }

    @PutMapping("/attach")  // используем чтоб приатачить картинки и продукт варианты к продукту
    // а в методах мы этот id перехватываем
    // @PathVariable Long id перехватывает id
    // @RequestBody ProductProcessDto dto реквест запрос, что именно ходим сделать
    public ResponseEntity<DataContainer<Boolean>> attach(@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        // ProductProcessDto прописанный класс чтоб приатачивать объекты
        productProcessFacade.attach(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/detach")
    public ResponseEntity<DataContainer<Boolean>> detach(@PathVariable Long id, @RequestBody ProductProcessDto dto) {
        productProcessFacade.detach(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }
}