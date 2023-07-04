package ua.com.alevel.facade.crud.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourImageDto;
import ua.com.alevel.facade.crud.TourImageCrudFacade;
import ua.com.alevel.persistence.sql.entity.tour.TourImage;
import ua.com.alevel.service.crud.tour.TourImageCrudService;

import java.util.List;

@Service
@AllArgsConstructor
public class TourImageCrudFacadeImpl implements TourImageCrudFacade {

    private final TourImageCrudService tourImageCrudService;

    @Override
    public void create(TourImageDto dto) {
        TourImage tourImage = new TourImage();
        tourImage.setImageUrl(dto.getImageUrl());
        tourImage.setMainImage(dto.getMainImage());
        tourImageCrudService.create(tourImage);
    }

    @Override
    public void update(Long id, TourImageDto dto) {
        TourImage tourImage = tourImageCrudService.findById(id);
        tourImage.setImageUrl(dto.getImageUrl());
        tourImage.setMainImage(dto.getMainImage());
        tourImageCrudService.create(tourImage);
    }

    @Override
    public void delete(Long id) {
        tourImageCrudService.delete(id);
    }

    @Override
    public TourImageDto findById(Long id) {
        return new TourImageDto(tourImageCrudService.findById(id));
    }

    @Override
    public DataTableResponse<TourImageDto> findAll(DataTableRequest request) {
        Page<TourImage> page = tourImageCrudService.findAll(request);
        DataTableResponse<TourImageDto> dataTableResponse = new DataTableResponse<>(request, page);
        List<TourImageDto> list = page.getContent().stream().map(TourImageDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
