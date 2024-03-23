package yugo.unit.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.repository.product.ProductRepository;
import yugo.service.crud.product.impl.ProductCrudServiceImpl;
import yugo.util.types_of_laptops.ProductBrandType;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductCrudServiceTest {

    private Product product = new Product();
    private final String PRODUCT_NAME = "MacBook";


    @InjectMocks
    private ProductCrudServiceImpl productCrudService;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void ProductShouldBeCreateWhenFieldsIsCorrect() {
//        given
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.APPLE);

//        when
        productCrudService.create(product);

//        then
        verify(productRepository, times(1)).save(product);
//        verify(productRepository, never()).save(product);

    }
}
