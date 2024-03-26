package yugo.unit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import yugo.exception.FieldEmptyException;
import yugo.persistence.sql.entity.product.Product;
import yugo.persistence.sql.repository.product.ProductRepository;
import yugo.service.crud.product.impl.ProductCrudServiceImpl;
import yugo.util.types_of_laptops.ProductBrandType;
import static yugo.util.ExceptionUtil.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductCrudServiceTest {

    private Product product = new Product();
    private static final String PRODUCT_NAME = "MacBook";


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

    @Test
    public void shouldBeExceptionIfProductNull() {
//        given
        product.setName(null);
        product.setProductBrand(ProductBrandType.APPLE);

//        when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> productCrudService.create(product));

//        then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeExceptionIfBrandNull() {
        product.setName(PRODUCT_NAME);
        product.setProductBrand(null);

        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> productCrudService.create(product));

        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_BRAND_IS_NOT_PRESENT);
    }

    @Test
    public void ProductShouldBeUpdatedWhenFieldsIsCorrect() {
//        given
        product.setId(1L);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.APPLE);

        product.setId(2L);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.APPLE);

//        when
        productCrudService.update(product);

//        then
        verify(productRepository, times(1)).save(product);

    }

    @Test
    public void shouldBeExceptionWhenUpdatedIfProductIdIsNull() {

        product.setId(null);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.APPLE);

        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> productCrudService.update(product));

        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeExceptionWhenUpdatedIfProductIdLessZero() {
        product.setId(0L);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.APPLE);

        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> productCrudService.update(product));

        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_INCORRECT);
    }

    @Test
    public void shouldBeFindByIdWhenIdIsCorrect() {
        // given
        final Long id = 1L;
        product.setId(1L);
        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));

        // what
        product = productCrudService.findById(id);

        // then
        assertEquals(product.getId(), id);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsNull() {
        // given
        final Long id = null;

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> productCrudService.findById(id));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsZero() {
        // given
        final Long id = 0L;

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> productCrudService.findById(id));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_INCORRECT);
    }
}
