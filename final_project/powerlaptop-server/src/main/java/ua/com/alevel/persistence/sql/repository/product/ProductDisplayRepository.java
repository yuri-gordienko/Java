package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;
import ua.com.alevel.persistence.sql.type.DisplayType;

import java.util.List;

@Repository
public interface ProductDisplayRepository extends BaseEntityRepository<ProductDisplay> {

    List<ProductDisplay> findAllByDisplayResolutionAndDisplaySizeAndDisplayType(
            String displayResolution, String displaySize, DisplayType displayType);
}
