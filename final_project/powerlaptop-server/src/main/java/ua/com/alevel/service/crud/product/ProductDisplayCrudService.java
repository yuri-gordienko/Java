package ua.com.alevel.service.crud.product;

import ua.com.alevel.persistence.sql.entity.product.ProductDisplay;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.service.crud.CrudService;

import java.util.List;

public interface ProductDisplayCrudService extends CrudService<ProductDisplay> {

    List<ProductDisplay> findAllByDisplayResolutionAndDisplaySizeAndDisplayType(
            String displayResolution, String displaySize, DisplayType displayType);
}
