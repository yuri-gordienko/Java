package yugo.facade.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.product.ProductDto;
import yugo.facade.crud.ProductCrudFacade;
import yugo.persistence.sql.entity.product.Product;
import yugo.service.crud.product.ProductCrudService;

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
        productCrudService.update(product);
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
