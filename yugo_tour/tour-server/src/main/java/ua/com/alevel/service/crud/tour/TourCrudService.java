package ua.com.alevel.service.crud.tour;

import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.service.CrudService;

import java.util.Collection;

public interface TourCrudService extends CrudService<Tour> {

    Collection<Tour> findAll();
}
