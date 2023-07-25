package ua.com.alevel.controller.admin;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.com.alevel.data.dto.tour.TourProcessDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.process.TourProcessFacade;

@RestController
@AllArgsConstructor
@RequestMapping("/api/private/admin/tours/{id}/process")
public class TourProcessController {

    private final TourProcessFacade tourProcessFacade;

    @PutMapping("/attach")
    public ResponseEntity<DataContainer<Boolean>> attach(@PathVariable Long id, @RequestBody TourProcessDto dto) {
        tourProcessFacade.attach(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @PutMapping("/detach")
    public ResponseEntity<DataContainer<Boolean>> detach(@PathVariable Long id, @RequestBody TourProcessDto dto) {
        tourProcessFacade.detach(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));
    }
}
