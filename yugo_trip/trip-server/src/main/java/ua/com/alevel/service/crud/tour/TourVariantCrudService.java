package ua.com.alevel.service.crud.tour;

import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;
import ua.com.alevel.service.CrudService;

import java.util.Collection;

public interface TourVariantCrudService extends CrudService<TourVariant> {

    Collection<TourVariant> findByTour(Tour tour);

//    Long findTourIdByVariants(TourSearchDto dto);
}
