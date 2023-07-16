package ua.com.alevel.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourImageDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.crud.TourImageCrudFacade;
import ua.com.alevel.util.WebRequestUtil;

@RestController
@AllArgsConstructor
@RequestMapping("/api/private/admin/tour-images")
public class TourImageController {

    private final TourImageCrudFacade tourImageCrudFacade;

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody TourImageDto dto) {
        tourImageCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody TourImageDto dto, @PathVariable Long id) {
        tourImageCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        tourImageCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<TourImageDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tourImageCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<TourImageDto>>> findAll(WebRequest webRequest) {
        DataTableRequest request = WebRequestUtil.generateDataTableRequest(webRequest);
        return ResponseEntity.ok(new DataContainer<>(tourImageCrudFacade.findAll(request)));
    }
}
