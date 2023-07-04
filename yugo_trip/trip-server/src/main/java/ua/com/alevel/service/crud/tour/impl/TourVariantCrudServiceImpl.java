package ua.com.alevel.service.crud.tour.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;
import ua.com.alevel.persistence.sql.repository.tour.TourVariantRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.tour.TourVariantCrudService;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class TourVariantCrudServiceImpl implements TourVariantCrudService {

    private final TourVariantRepository tourVariantRepository;
    private final CrudHelperService<TourVariant, TourVariantRepository> crudHelperService;


    @Override
    public void create(TourVariant entity) {
        crudHelperService.create(entity, tourVariantRepository);
    }

    @Override
    public void update(TourVariant entity) {
        crudHelperService.update(entity, tourVariantRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, tourVariantRepository);
    }

    @Override
    public TourVariant findById(Long id) {
        return crudHelperService.findById(id, tourVariantRepository);
    }

    @Override
    public Page<TourVariant> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, tourVariantRepository);
    }

    @Override
    public TourVariant findByTour(Tour tour) {
        return tourVariantRepository
                .findByTour(tour)
                .orElseThrow(() -> new RuntimeException("Tour variant not found by tour id: " + tour.getId()));
    }

//    @Override
//    public Collection<TourVariant> findByTour(Tour tour) {
//        return tourVariantRepository.findByTour(tour);
//    }
}
