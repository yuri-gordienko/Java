package ua.com.alevel.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.product.ProductDto;
import ua.com.alevel.facade.crud.ProductCrudFacade;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.service.crud.product.ProductCrudService;

import java.util.List;

@Service
public class ProductCrudFacadeImpl implements ProductCrudFacade {

    private final ProductCrudService productCrudService;

    public ProductCrudFacadeImpl(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @Override
    public void create(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setProductBrand(dto.getProductBrand());
        product.setDescription(dto.getDescription());
        productCrudService.create(product);
    }

    @Override
    public void update(Long id, ProductDto dto) {
        Product product = productCrudService.findById(id);
        product.setName(dto.getName());
        product.setProductBrand(dto.getProductBrand());
        product.setDescription(dto.getDescription());
        productCrudService.create(product);
    }

    @Override
    public void delete(Long id) {
        productCrudService.delete(id);
    }

    @Override
    public ProductDto findById(Long id) {
        return new ProductDto(productCrudService.findById(id));
    }

    @Override
    public DataTableResponse<ProductDto> findAll(DataTableRequest request) {
        Page<Product> page = productCrudService.findAll(request);
        DataTableResponse<ProductDto> dataTableResponse = new DataTableResponse<ProductDto>(request, page);
        List<ProductDto> list = page.getContent().stream().map(ProductDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }
}
