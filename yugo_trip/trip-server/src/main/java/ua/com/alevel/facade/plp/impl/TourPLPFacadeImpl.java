package ua.com.alevel.facade.plp.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ua.com.alevel.data.dto.tour.TourPLPDto;
import ua.com.alevel.facade.plp.TourPLPFacade;
import ua.com.alevel.service.crud.tour.TourCrudService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TourPLPFacadeImpl implements TourPLPFacade {

    private final TourCrudService tourCrudService;

    @Override
    public Collection<TourPLPDto> findAll() {
        return tourCrudService.findAll()
                .stream()
                .map(TourPLPDto::new)
                .toList();
    }
}