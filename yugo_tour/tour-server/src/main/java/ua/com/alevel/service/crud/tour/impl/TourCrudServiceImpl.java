package ua.com.alevel.service.crud.tour.impl;

import lombok.AllArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.exception.FieldEmptyException;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.repository.tour.TourRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.tour.TourCrudService;

import java.util.Collection;

import static ua.com.alevel.util.ExceptionUtil.*;

@Service
@Transactional
@AllArgsConstructor
public class TourCrudServiceImpl implements TourCrudService {

    private final TourRepository tourRepository;
    private final CrudHelperService<Tour, TourRepository> crudHelperService;


    @Override
    public void create(Tour entity) {
        isValidTour(entity);
        crudHelperService.create(entity, tourRepository);
    }

    @Override
    public void update(Tour entity) {
        isValidTour(entity);
        isValidId(entity.getId());
        crudHelperService.update(entity, tourRepository);
    }

    @Override
    public void delete(Long id) {
        isValidId(id);
        crudHelperService.delete(id, tourRepository);
    }

    @Override
    public Tour findById(Long id) {
        isValidId(id);
        return crudHelperService.findById(id, tourRepository);
    }

    @Override
    public Page<Tour> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, tourRepository);
    }

    @Override
    public Collection<Tour> findAll() {
        return tourRepository.findAll();
    }

    private void isValidTour(Tour entity) {
        if (StringUtils.isBlank(entity.getCountry())) {
                throw new FieldEmptyException(TOUR_IS_NOT_PRESENT);
        }
    }

    private void isValidId(Long id) {
        if (id == null) {
            throw new FieldEmptyException(ENTITY_ID_IS_NOT_PRESENT);
        }
        if (id <= 0) {
            throw new FieldEmptyException(ENTITY_ID_IS_INCORRECT);
        }
    }
}
