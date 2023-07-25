package ua.com.alevel.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.crud.TourCrudFacade;

@RestController
@RequestMapping("/api/private/admin/tours")
@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
public class TourController {

    private final TourCrudFacade tourCrudFacade;

    @Operation(summary = "Create product only by admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tour created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Boolean.class)) }),
    })
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody TourDto dto) {
        tourCrudFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody TourDto dto, @PathVariable Long id) {
        tourCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        tourCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @Operation(summary = "Get a tour by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<DataContainer<TourDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tourCrudFacade.findById(id)));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<DataContainer<DataTableResponse<TourDto>>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sort,
            @RequestParam(defaultValue = "id") String order) {
        DataTableRequest request = new DataTableRequest();
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(tourCrudFacade.findAll(request)));
    }
}