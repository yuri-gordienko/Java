package yugo.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.product.ProductImageDto;
import yugo.facade.ProductImageCrudFacade;
import yugo.persistence.sql.entity.product.ProductImage;
import yugo.service.crud.product.ProductImageCrudService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductImageCrudFacadeImpl implements ProductImageCrudFacade {

    private final ProductImageCrudService productImageCrudService;

    @Override
    public void create(ProductImageDto dto) {
        ProductImage productImage = new ProductImage();
        productImage.setImageUrl(dto.getImageUrl());
        productImage.setMainImage(dto.getMainImage());
        productImageCrudService.create(productImage);
    }

    @Override
    public void update(Long id, ProductImageDto dto) {
        ProductImage productImage = productImageCrudService.findById(id);
        productImage.setImageUrl(dto.getImageUrl());
        productImage.setMainImage(dto.getMainImage());
        productImageCrudService.update(productImage);
    }

    @Override
    public void delete(Long id) {
        productImageCrudService.delete(id);
    }

    @Override
    public ProductImageDto findById(Long id) {

        return new ProductImageDto(productImageCrudService.findById(id));
    }

    @Override
    public DataTableResponse<ProductImageDto> findAll(DataTableRequest request) {
        Page<ProductImage> page = productImageCrudService.findAll(request);
        DataTableResponse<ProductImageDto> dataTableResponse = new DataTableResponse<>(request, page);
        List<ProductImageDto> list = page.getContent().stream().map(ProductImageDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
