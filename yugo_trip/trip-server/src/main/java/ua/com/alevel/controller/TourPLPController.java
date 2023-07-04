package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.alevel.data.dto.tour.TourPLPDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.plp.TourPLPFacade;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/tours/plp")
public class TourPLPController {

    private final TourPLPFacade tourPLPFacade;

    @GetMapping
    public ResponseEntity<DataContainer<Collection<TourPLPDto>>> findAll() {
        return ResponseEntity.ok(new DataContainer<>(tourPLPFacade.findAll()));
    }
}