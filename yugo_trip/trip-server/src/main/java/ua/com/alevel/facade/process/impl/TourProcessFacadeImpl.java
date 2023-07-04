package ua.com.alevel.facade.process.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ua.com.alevel.data.dto.tour.TourProcessDto;
import ua.com.alevel.facade.process.TourProcessFacade;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;
import ua.com.alevel.service.crud.tour.TourCrudService;
import ua.com.alevel.service.crud.tour.TourImageCrudService;
import ua.com.alevel.service.crud.tour.TourVariantCrudService;

import java.util.Set;

@Service
@AllArgsConstructor
public class TourProcessFacadeImpl implements TourProcessFacade {

    private final TourCrudService tourCrudService;
    private final TourVariantCrudService tourVariantCrudService;
    private final TourImageCrudService tourImageCrudService;

    @Override
    public void attach(Long id, TourProcessDto dto) {
        Tour tour = tourCrudService.findById(id);
        TourVariant tourVariant = tourVariantCrudService.findById(dto.getTourVariantId());
        Set<TourImage> tourImages = tourImageCrudService.findAllByIdIn(dto.getTourImages());
        tourVariant.setTour(tour);
        tourVariantCrudService.update(tourVariant);
        tour.setTourImages(tourImages);
        tourCrudService.update(tour);
    }

    @Override
    public void detach(Long id, TourProcessDto dto) {
    }
}