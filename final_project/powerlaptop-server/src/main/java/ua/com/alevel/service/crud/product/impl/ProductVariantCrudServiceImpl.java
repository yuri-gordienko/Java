package ua.com.alevel.service.crud.product.impl;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.dto.product.ProductSearchDto;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.product.ProductVariantRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductCrudService;
import ua.com.alevel.service.crud.product.ProductDisplayCrudService;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static ua.com.alevel.util.ExceptionUtil.ENTITY_NOT_FOUND;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {

    private final ProductCrudService productCrudService;
    private final ProductDisplayCrudService productDisplayCrudService;
    private final ProductVariantRepository productVariantRepository;
    private final CrudHelperService<ProductVariant, ProductVariantRepository> crudHelperService;

    @Override
    public void create(ProductVariant entity) {

//        entity.setProduct(productCrudService.findById(1L));
//        entity.setPrice(new BigDecimal("1000.00"));
//        entity.setWireless("");
//        entity.setQuantity(1);
//        entity.setBattery("");
//        entity.setCamera("");
//        entity.setDepth(99.99);
//        entity.setCode(UUID.randomUUID().toString());
//        entity.setHeight(99.99);
//        entity.setProductDisplay(productDisplayCrudService.findById(1L));
//        entity.setWeight(99.99);
//        entity.setWidth(99.99);

        crudHelperService.create(entity, productVariantRepository);
    }

    @Override
    public void update(ProductVariant entity) {
        crudHelperService.update(entity, productVariantRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productVariantRepository);
    }

    @Override
    public ProductVariant findById(Long id) {
        return crudHelperService.findById(id, productVariantRepository);
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productVariantRepository);
    }

    @Override
    public Collection<ProductVariant> findByProduct(Product product) {
        return productVariantRepository.findByProduct(product);
    }

    @Override
    public Long findProductIdByVariants(ProductSearchDto dto) {
        Product product = productCrudService.findById(dto.getProductId());
        List<ProductDisplay> productDisplayList = productDisplayCrudService.findAllByDisplayResolutionAndDisplaySizeAndDisplayType(
                dto.getDisplayResolution(), dto.getDisplaySize(), dto.getDisplayType());
        if (CollectionUtils.isEmpty(productDisplayList)) {
            throw new EntityNotFoundException(ENTITY_NOT_FOUND);
        }
        ProductVariant productVariant = productVariantRepository.findByProductAndOsAndCpuAndRamAndSsdAndColorAndProductDisplay(
                product,
                dto.getOs(),
                dto.getCpu(),
                dto.getRam(),
                dto.getSsd(),
                dto.getColor(),
                productDisplayList.get(0)
        )
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND));
        return productVariant.getId();
    }
}
