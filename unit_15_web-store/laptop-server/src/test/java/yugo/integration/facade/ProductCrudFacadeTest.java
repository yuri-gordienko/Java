package yugo.integration.facade;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yugo.data.dto.product.ProductDto;
import yugo.facade.crud.ProductCrudFacade;
import yugo.util.types_of_laptops.ProductBrandType;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductCrudFacadeTest {

    @Autowired
    private ProductCrudFacade productCrudFacade;

    private static ProductDto productDto = new ProductDto();
    private static final String PRODUCT_NAME = "MacBook";
    private static final Long ID = 1L;

    @BeforeAll
    static void setUp() {
        productDto.setName(PRODUCT_NAME);
        productDto.setProductBrand(ProductBrandType.APPLE);
    }

    @Test
    @Order(1)
    public void shouldBeCreateProductWhenFieldsIsCorrect() {
        // given
        productCrudFacade.create(productDto);

        // when
        productDto = productCrudFacade.findById(ID);

        // then
        assertThat(productDto.getId()).isEqualTo(ID);
    }
}
