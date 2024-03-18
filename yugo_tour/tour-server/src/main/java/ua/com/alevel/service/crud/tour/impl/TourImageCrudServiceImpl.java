package ua.com.alevel.service.crud.tour.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.persistence.sql.repository.tour.TourImageRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.tour.TourImageCrudService;

import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class TourImageCrudServiceImpl implements TourImageCrudService {

    private final TourImageRepository tourImageRepository;
    private final CrudHelperService<TourImage, TourImageRepository> crudHelperService;

    @Override
    public void create(TourImage entity) {
        crudHelperService.create(entity, tourImageRepository);
    }

    @Override
    public void update(TourImage entity) {
        crudHelperService.update(entity, tourImageRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, tourImageRepository);
    }

    @Override
    public TourImage findById(Long id) {
        return crudHelperService.findById(id, tourImageRepository);
    }

    @Override
    public Page<TourImage> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, tourImageRepository);
    }

    @Override
    public Set<TourImage> findAllByIdIn(Set<Long> ids) {
        return tourImageRepository.findAllByIdIn(ids);
    }
}
