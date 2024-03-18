package ua.com.alevel.facade.pdp.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import ua.com.alevel.data.dto.tour.TourPDPDto;
import ua.com.alevel.facade.pdp.TourPDPFacade;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;
import ua.com.alevel.service.crud.tour.TourCrudService;
import ua.com.alevel.service.crud.tour.TourVariantCrudService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class TourPDPFacadeImpl implements TourPDPFacade {

    private final TourCrudService tourCrudService;
    private final TourVariantCrudService tourVariantCrudService;

    @Override
    public TourPDPDto findById(Long id) {
        Tour tour = tourCrudService.findById(id);
        Collection<TourVariant> tourVariants = tourVariantCrudService.findByTour(tour);
        return new TourPDPDto(tour, tourVariants);
    }
}
