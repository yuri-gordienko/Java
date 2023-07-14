package ua.com.alevel.controller.admin;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.crud.TourCrudFacade;
import ua.com.alevel.util.WebRequestUtil;

@RestController
@AllArgsConstructor
@RequestMapping("/tours")
public class TourController {

    private final TourCrudFacade tourCrudFacade;

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody TourDto dto) {
        tourCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody TourDto dto, @PathVariable Long id) {
        tourCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        tourCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<TourDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tourCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<TourDto>>> findAll(WebRequest webRequest) {
        DataTableRequest request = WebRequestUtil.generateDataTableRequest(webRequest);
        return ResponseEntity.ok(new DataContainer<>(tourCrudFacade.findAll(request)));
    }
}
