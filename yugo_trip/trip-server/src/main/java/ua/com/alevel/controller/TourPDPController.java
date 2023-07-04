package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.data.dto.tour.TourPDPDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.pdp.TourPDPFacade;

@RestController
@AllArgsConstructor
@RequestMapping("tours/{id}/pdp")
public class TourPDPController {

    private final TourPDPFacade tourPDPFacade;

    @GetMapping
    public ResponseEntity<DataContainer<TourPDPDto>> findByTour(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(tourPDPFacade.findById(id)));
    }
}
