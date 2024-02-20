package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.repository.product.ProductDisplayRepository;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductDisplayCrudService;

import java.util.List;

@Service
@Transactional
public class ProductDisplayCrudServiceImpl implements ProductDisplayCrudService {

    private final ProductDisplayRepository productDisplayRepository;
    private final CrudHelperService<ProductDisplay, ProductDisplayRepository> crudHelperService;

    public ProductDisplayCrudServiceImpl(
            ProductDisplayRepository productDisplayRepository,
            CrudHelperService<ProductDisplay, ProductDisplayRepository> crudHelperService) {
        this.productDisplayRepository = productDisplayRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(ProductDisplay entity) {
        crudHelperService.create(entity, productDisplayRepository);
    }

    @Override
    public void update(ProductDisplay entity) {
        crudHelperService.update(entity, productDisplayRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productDisplayRepository);
    }

    @Override
    public ProductDisplay findById(Long id) {
        return crudHelperService.findById(id, productDisplayRepository);
    }

    @Override
    public Page<ProductDisplay> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productDisplayRepository);
    }

    @Override
    public List<ProductDisplay> findAllByDisplayResolutionAndDisplaySizeAndDisplayType(String displayResolution, String displaySize, DisplayType displayType) {
        return productDisplayRepository.findAllByDisplayResolutionAndDisplaySizeAndDisplayType(displayResolution, displaySize, displayType);
    }
}
