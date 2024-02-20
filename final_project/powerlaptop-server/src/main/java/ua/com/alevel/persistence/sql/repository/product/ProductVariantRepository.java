package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.sql.dto.ProductVariantMinDto;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;
import ua.com.alevel.persistence.sql.type.OsType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);

//    @Query(value = "select distinct cpu, color, product_id from product_variants", nativeQuery = true)
    @Query(value = "select distinct new ua.com.alevel.persistence.sql.dto.ProductVariantMinDto(pv.cpu, pv.color, pv.product) from ProductVariant as pv")
    Collection<ProductVariantMinDto> find();

    List<ProductVariant> findAllByCodeIn(List<String> codes);

    Optional<ProductVariant> findByProductAndOsAndCpuAndRamAndSsdAndColorAndProductDisplay(
            Product product, OsType os, String cpu, Integer ram, Integer ssd, String color, ProductDisplay productDisplay
    );
}
