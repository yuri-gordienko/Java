package ua.com.alevel.facade.crud.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourDto;
import ua.com.alevel.facade.crud.TourCrudFacade;
import ua.com.alevel.persistence.sql.entity.tour.Tour;
import ua.com.alevel.service.crud.tour.TourCrudService;

import java.util.List;

@Service
@AllArgsConstructor
public class TourCrudFacadeImpl implements TourCrudFacade {

    private final TourCrudService tourCrudService;

    @Override
    public void create(TourDto dto) {
        Tour tour = new Tour();
        tour.setCountry(dto.getCountry());
        tour.setDescription(dto.getDescription());
        tourCrudService.create(tour);
    }

    @Override
    public void update(Long id, TourDto dto) {
        Tour tour = tourCrudService.findById(id);
        tour.setCountry(dto.getCountry());
        tour.setDescription(dto.getDescription());
        tourCrudService.create(tour);
    }

    @Override
    public void delete(Long id) {
        tourCrudService.delete(id);
    }

    @Override
    public TourDto findById(Long id) {
        return new TourDto(tourCrudService.findById(id));
    }

    @Override
    public DataTableResponse<TourDto> findAll(DataTableRequest request) {
        Page<Tour> page = tourCrudService.findAll(request);
        DataTableResponse<TourDto> dataTableResponse = new DataTableResponse<TourDto>(request, page);
        List<TourDto> list = page.getContent().stream().map(TourDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}