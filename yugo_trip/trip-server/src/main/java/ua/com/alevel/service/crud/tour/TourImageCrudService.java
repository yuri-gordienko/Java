package ua.com.alevel.service.crud.tour;

import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.service.CrudService;

import java.util.Set;

public interface TourImageCrudService extends CrudService<TourImage> {

    Set<TourImage> findAllByIdIn(Set<Long> ids);
}
