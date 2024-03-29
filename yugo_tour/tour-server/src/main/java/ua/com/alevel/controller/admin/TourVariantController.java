package ua.com.alevel.controller.admin;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourVariantDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.crud.TourVariantCrudFacade;
import ua.com.alevel.util.WebRequestUtil;

@RestController
@AllArgsConstructor
@RequestMapping("/api/private/admin/tour-variants")
public class TourVariantController {

    private final TourVariantCrudFacade tourVariantCrudFacade;

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody TourVariantDto dto) {
        tourVariantCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody TourVariantDto dto, @PathVariable Long id) {
        tourVariantCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        tourVariantCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<TourVariantDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tourVariantCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<TourVariantDto>>> findAll(WebRequest webRequest) {
        DataTableRequest request = WebRequestUtil.generateDataTableRequest(webRequest);
        return ResponseEntity.ok(new DataContainer<>(tourVariantCrudFacade.findAll(request)));
    }
}
