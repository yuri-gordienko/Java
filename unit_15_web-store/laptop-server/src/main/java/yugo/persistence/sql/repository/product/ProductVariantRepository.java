package yugo.persistence.sql.repository.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.entity.product.ProductVariant;
import yugo.persistence.sql.repository.BaseEntityRepository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> {

    Collection<ProductVariant> findByProduct(Product product);

//    // @Query(value = "select distinct cpu, color, product_id from product_variants", nativeQuery = true)
//    // пишем запрос в БД sql какую инфо выдавать в БД эластика для строки серч
//    @Query(value = "select distinct new ua.com.alevel.persistence.sql.dto.ProductVariantMinDto(pv.cpu, pv.color, pv.product) from ProductVariant as pv")
//    Collection<ProductVariantMinDto> find();
//
//    List<ProductVariant> findAllByCodeIn(List<String> codes);   // вытягиваем у поставщика продукты по коду
}
