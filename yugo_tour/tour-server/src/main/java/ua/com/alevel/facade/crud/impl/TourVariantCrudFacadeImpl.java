package ua.com.alevel.facade.crud.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.tour.TourVariantDto;
import ua.com.alevel.facade.crud.TourVariantCrudFacade;
import ua.com.alevel.persistence.sql.entity.tour.TourVariant;
import ua.com.alevel.service.crud.tour.TourVariantCrudService;

import java.util.List;

@Service
@AllArgsConstructor
public class TourVariantCrudFacadeImpl implements TourVariantCrudFacade {

    private final TourVariantCrudService tourVariantCrudService;

    @Override
    public void create(TourVariantDto dto) {
        TourVariant tourVariant = new TourVariant();
        tourVariant.setRout(dto.getRout());
        tourVariantCrudService.create(tourVariant);
    }

    @Override
    public void update(Long id, TourVariantDto dto) {
        TourVariant tourVariant = tourVariantCrudService.findById(id);
        tourVariant.setRout(dto.getRout());
        tourVariantCrudService.create(tourVariant);
    }

    @Override
    public void delete(Long id) {
        tourVariantCrudService.delete(id);
    }

    @Override
    public TourVariantDto findById(Long id) {
        return new TourVariantDto(tourVariantCrudService.findById(id));
    }

    @Override
    public DataTableResponse<TourVariantDto> findAll(DataTableRequest request) {
        Page<TourVariant> page = tourVariantCrudService.findAll(request);
        DataTableResponse<TourVariantDto> dataTableResponse = new DataTableResponse<>(request, page);
        List<TourVariantDto> list = page.getContent().stream().map(TourVariantDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
