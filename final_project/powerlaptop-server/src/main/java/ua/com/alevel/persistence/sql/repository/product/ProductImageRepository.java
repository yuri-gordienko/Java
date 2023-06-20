package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Set;

@Repository
public interface ProductImageRepository extends BaseEntityRepository<ProductImage> {

    // для получения всех картинок по id используем Спринг дату
    // findAllByIdIn аналог sql запроса чтоб получить все по конкретным id
    Set<ProductImage> findAllByIdIn(Set<Long> ids);
}
