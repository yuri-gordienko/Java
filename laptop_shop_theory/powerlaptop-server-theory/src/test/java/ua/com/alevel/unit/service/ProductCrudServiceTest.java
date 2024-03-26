package ua.com.alevel.unit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import ua.com.alevel.exception.FieldEmptyException;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.product.ProductRepository;
import ua.com.alevel.persistence.sql.type.ProductBrandType;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.impl.ProductCrudServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static ua.com.alevel.util.ExceptionUtil.*;

@SpringBootTest // подключаем Спрингбуттест, чтоб тесты работали
public class ProductCrudServiceTest {

    @InjectMocks    // создает экземпляр класса, который тестируем. @InjectMocks выполняет функцию как "new"
    private ProductCrudServiceImpl service; // подключаем, т.к. сама имплементация методов находится в этом классе

    @Mock   // помечаем класс-зависимость, без которой ProductCrudServiceImpl работать не будет
    private ProductRepository productRepository;

    @Mock   // библиотека Мокито подставляет тестируемый класс в пустом состоянии, а потом набрасываем методы проверки
    private CrudHelperService<Product, ProductRepository> crudHelperService; // тоже нужен, т.к. у класса
    // ProductCrudServiceImpl есть 2 зависимости

    private Product product = new Product(); // искусственно создаем Продукт, для проверки работы тестов

    private static final String PRODUCT_NAME = "TestName";

    // есть конвенции как должен называться вызываемый метод
    // названия метода своего рода Спецификация
    @Test   // обозначаем так сам тест метод
    // хочу чтобы создание продукта где филды все корректные
    // на самом деле этот метод по факту ошибки не выявляет
    public void shouldBeCreateProductWhenCrudHelperServiceWasCalled() {
        // given    - какие условия имеем перед вызовом тестируемого метода (предтестовое состояние)
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when     - вызываем непосредственно сам метод (сам вызов тестового класса)
        service.create(product);    // говорим, что будем проверять (какой метод, какую сущность)

        // then     - проверяем как код работает (что хотим проверить в результате самого теста)
        verify(crudHelperService, times(1)).create(product, productRepository);
        // проверяем вызывается ли метод create в априоре или не вызывается
    }

    @Test
    public void shouldBeCreateProductWhenProductBrandIsNull() {
        // given
        product.setProductBrand(null);
        product.setName(PRODUCT_NAME);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.create(product));
        // Assertions(утверждение status = Status.STABLE).assertThrows(условия утверждения)
        // -> (public interface Executable { void execute() throws Throwable } (что должно выполниться)
        // При вызове метода create, если продукт пустой или частично пустой, то должен вылететь "Exception"

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_BRAND_IS_NOT_PRESENT);
        // метод assertThat класса @CheckReturnValue - проверяет возвращаемые объекты
        // isInstanceOf - должен быть именно тот "Exception", который мы указали в "when"
        // getMessage()).isEqualTo - сообщение должно соответствовать "указанному сообщению"
    }

    @Test
    // это более действенный метод, он проверяет возникают ли экзепшены
    public void shouldBeCreateProductWhenNameIsNull() {
        // given  предзаданная ситуация в которой продукт бренд налл
        product.setName(null);
        product.setProductBrand(ProductBrandType.HP);

        // when   WhenNameIsNull мы ожидаем, что вылетит экзепшн
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.create(product));

        // then     проверяем, был ли вызван экзкпшн и даже проверяем что меседж экзепшена равен чему-то
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeUpdateProductWhenCrudHelperServiceWasCalled() {
        // given
        product.setId(1L);  // принудительно назначили, чтоб проверить как работает тест
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        service.update(product);

        // then
        verify(crudHelperService, times(1)).update(product, productRepository);
    }

    @Test
    public void shouldBeUpdateProductWhenProductIdIsNull() {
        // given
        product.setId(null);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeUpdateProductWhenProductIdIsLessZero() {
        // given
        product.setId(0L);
        product.setName(PRODUCT_NAME);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_INCORRECT);
    }

    @Test
    public void shouldBeUpdateProductWhenProductBrandIsNull() {
        // given
        product.setProductBrand(null);
        product.setName(PRODUCT_NAME);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_BRAND_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeUpdateProductWhenNameIsNull() {
        // given
        product.setName(null);
        product.setProductBrand(ProductBrandType.HP);

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.update(product));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(PRODUCT_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsCorrect() {
        // given
        final Long id = 1L; // эмуляция получения на вход id
        product.setId(1L);  // создаем продукт с неким id
        when(crudHelperService.findById(id, productRepository)).thenReturn(product); // эмуляция готового продукта с id

        // when
        product = service.findById(id); // вызываем этот метод

        // then
        assertEquals(id, product.getId());  // ожидаем что полученный id, будет совпадать с id продукта в БД
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsNull() {
        // given
        final Long id = null;

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.findById(id));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductWhenIdIsZero() {
        // given
        final Long id = 0L;

        // when
        Exception thrown = Assertions.assertThrows(FieldEmptyException.class, () -> service.findById(id));

        // then
        assertThat(thrown).isInstanceOf(FieldEmptyException.class);
        assertThat(thrown.getMessage()).isEqualTo(ENTITY_ID_IS_INCORRECT);
    }
}
