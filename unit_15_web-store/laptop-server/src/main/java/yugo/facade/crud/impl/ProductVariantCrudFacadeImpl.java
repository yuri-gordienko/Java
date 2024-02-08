package yugo.facade.crud.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
import yugo.data.dto.product.ProductVariantDto;
import yugo.facade.crud.ProductVariantCrudFacade;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.service.crud.product.ProductVariantCrudService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductVariantCrudFacadeImpl implements ProductVariantCrudFacade {

    private final ProductVariantCrudService productVariantCrudService;

    @Override
    public void create(ProductVariantDto dto) {
        ProductVariant productVariant = new ProductVariant();
//        convertProductVariantDtoToProductVariant(dto, productVariant);
        productVariant.setOs(dto.getOs());
        productVariant.setCpu(dto.getCpu());
        productVariant.setRam(dto.getRam());
        productVariant.setSsd(dto.getSsd());
        productVariant.setColor(dto.getColor());
        productVariantCrudService.create(productVariant);
    }

    @Override
    public void update(Long id, ProductVariantDto dto) {
        ProductVariant productVariant = productVariantCrudService.findById(id);
        convertProductVariantDtoToProductVariant(dto, productVariant);
        productVariantCrudService.update(productVariant);
    }

    @Override
    public void delete(Long id) {
        productVariantCrudService.delete(id);
    }

    @Override
    public ProductVariantDto findById(Long id) {

        return new ProductVariantDto(productVariantCrudService.findById(id));
    }

    @Override
    public DataTableResponse<ProductVariantDto> findAll(DataTableRequest request) {
        Page<ProductVariant> page = productVariantCrudService.findAll(request);
        DataTableResponse<ProductVariantDto> dataTableResponse = new DataTableResponse<>(request, page);
        List<ProductVariantDto> list = page.getContent().stream().map(ProductVariantDto::new).toList();
        dataTableResponse.setItems(list);
        return dataTableResponse;
    }

    private void convertProductVariantDtoToProductVariant(ProductVariantDto dto, ProductVariant productVariant) {
        productVariant.setOs(dto.getOs());
        productVariant.setCpu(dto.getCpu());
        productVariant.setRam(dto.getRam());
        productVariant.setSsd(dto.getSsd());
        productVariant.setColor(dto.getColor());
    }
}
