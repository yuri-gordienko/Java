package yugo.integration.facade;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yugo.data.datatable.DataTableRequest;
import yugo.data.datatable.DataTableResponse;
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
    private static DataTableRequest request = new DataTableRequest();
    private static final String PRODUCT_NAME = "MacBook";
    private static final String PRODUCT_NAME_UPDATED = "MacBook Pro";
    private static final Long SETED_ID = 1L;
    private static final Long RECIEVED_ID = 1L;


    @BeforeAll
    static void setUp() {
        productDto.setId(SETED_ID);
        productDto.setName(PRODUCT_NAME);
        productDto.setProductBrand(ProductBrandType.APPLE);
        request.setPage(0);
        request.setSize(10);
        request.setSort("desc");
        request.setOrder("id");
    }

    @Test
    @Order(1)
    public void shouldBeCreateProductWhenFieldsIsCorrect() {
        // given
        productCrudFacade.create(productDto);

        // when
        productDto = productCrudFacade.findById(SETED_ID);

        // then
        assertThat(productDto.getId()).isEqualTo(SETED_ID);
        assertThat(productDto.getName()).isEqualTo(PRODUCT_NAME);
        assertThat(productDto.getProductBrand()).isEqualTo(ProductBrandType.APPLE);
    }

    @Test
    @Order(2)
    public void shouldBeUpdateProductWhenFieldsIsCorrect() {
        // given
        productDto.setName(PRODUCT_NAME_UPDATED);
        productCrudFacade.update(RECIEVED_ID, productDto);

        // when
        productDto = productCrudFacade.findById(SETED_ID);

        // then
        assertThat(productDto.getName()).isEqualTo(PRODUCT_NAME_UPDATED);
    }

    @Test
    @Order(3)
    public void shouldBeFindAllProducts() {
        // given
        productCrudFacade.create(productDto);

        // when
        DataTableResponse<ProductDto> response = productCrudFacade.findAll(request);
        // then
        assertThat(response.getTotalElements()).isEqualTo(2L);
        assertThat(response.getTotalPages()).isEqualTo(1);
    }
}
