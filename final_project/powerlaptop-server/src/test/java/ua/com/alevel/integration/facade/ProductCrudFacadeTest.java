package ua.com.alevel.integration.facade;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.product.ProductDto;
import ua.com.alevel.facade.crud.ProductCrudFacade;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.type.ProductBrandType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest // класс типа тест
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // важная аннотация, говорит что должна быть последовательность вызовов методов
// в отличик от моков, где каждый метод может вызываться в любом порядке
// пишется на уровне контроллера
public class ProductCrudFacadeTest {

    @Autowired  // включает интеграционные методы - эмулирует поведение программы
    // фасад вызывает сервис, сервис вызывает репозиторий - вся цепочка вызовов
    private ProductCrudFacade productCrudFacade;    // подключаем тестируемый класс

    private static final String PRODUCT_NAME = "TestName";
    private static final String PRODUCT_NAME_UPDATE = "TestNameUpdate";
    private static final Long ID = 1L;
    private static ProductDto productDto = new ProductDto();
    private static DataTableRequest request = new DataTableRequest();   // и создаем искусственно табличку

    @BeforeAll  // этот метод отработает перед тем как отработают все тест методы - инициализируем филды
    static void setUp() {   // и создаем искусственно табличку (для проверки работы теста №3)
        productDto.setName(PRODUCT_NAME);
        productDto.setProductBrand(ProductBrandType.HP);
        request.setPage(0);
        request.setSize(10);
        request.setSort("desc");
        request.setOrder("id");
    }

    @Test
    @Order(1)   // номер, в каком порядке должен вызываться тестируемый метод
    public void shouldBeCreateProductWhenFieldsIsCorrect() {
        // given
        productCrudFacade.create(productDto);   // проверяем создается ли продукт

        // when
        productDto = productCrudFacade.findById(ID);    // тестируем находится ли продукт

        // then
        assertThat(productDto.getId()).isEqualTo(ID);   // проверяем на соответствие запрашиваемого id с существующим
        assertThat(productDto.getName()).isEqualTo(PRODUCT_NAME);
        assertThat(productDto.getProductBrand()).isEqualTo(ProductBrandType.HP);
    }

    @Test
    @Order(2)   // второй, т.к. зафалиться если вызовится первым, т.к. продукт еще не создан
    public void shouldBeUpdateProductWhenFieldsIsCorrect() {
        // given
        productDto.setName(PRODUCT_NAME_UPDATE);
        productCrudFacade.update(ID, productDto);   // вызываем метод по обновлению

        // when
        productDto = productCrudFacade.findById(ID); // смотрим что он его находит

        // then
        // убеждаемся, что у вытащенного продукта из БД поле обновилось
        assertThat(productDto.getName()).isEqualTo(PRODUCT_NAME_UPDATE);
    }

    @Test
    @Order(3)
    public void shouldBeFindAllProducts() {
        // given
        productCrudFacade.create(productDto);

        // when
        DataTableResponse<ProductDto> response = productCrudFacade.findAll(request);    // запрашиваем все продукты

        // then
        // 2 раза создали продукт (в 2х предыдущих тестах), теперь проверили, что он действительно 2  раза создался)
        assertThat(response.getTotalElements()).isEqualTo(2L);
        assertThat(response.getTotalPages()).isEqualTo(1);  // проверяем что страница 1
    }
}
