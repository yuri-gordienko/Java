package ua.com.alevel.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.data.datatable.DataTableResponse;
import ua.com.alevel.data.dto.product.ProductDto;
import ua.com.alevel.data.response.DataContainer;
import ua.com.alevel.facade.crud.ProductCrudFacade;

@RestController // тип класса, помечают классы, которые принимают http запросы
@RequestMapping("/api/admin/products")    // говорим по какому url + ресурсы можно придти к конкретному контроллеру
public class ProductCrudController { // отвечает за автомат подставление локального IP и порта
    // каждый конкретный контроллер отвечаем конкретно за свой конкретный ресурс

    private final ProductCrudFacade productCrudFacade;  // с ним и работает контроллер

    public ProductCrudController(ProductCrudFacade productCrudFacade) { // конструктор

        this.productCrudFacade = productCrudFacade;
    }

    @PostMapping    // пост запрос для создание. работаем на основании Реста, у нас не будет сервер сайта
    // мы не будем возвращать html странички, возвращаются готовые модели - дает все возможные варианты использования Реста
    // приняли джейсончик, вернули джейсончик
    // эти типы запросов - это энд поинты (точки коммуникации фронта и бэка)
    // по названию запроса Джава понимает какой метод должен отработать (в данном случае 201)
    // на Постзапрос с фронта, мы должны что-то ответить для ребят на фронте, поэтому любой ответ в виде джейсона мы
    // заворачиваем в дата контейнер. фронт получает статус 201 на криейт и бади (данные по запросу) обернутые в дата контейнер
    // если это криейт, то булевое значение <Boolean>>, если не создасться то будет эксепшн
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody ProductDto dto) {
        // чтоб ответить автоматически не конвертируя джава объект ProductDto в джейсон, Спринг делает это через @RequestBody
        productCrudFacade.create(dto);  // создали ДТОшку, и выкидываем ее через контроллер на фронт
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer<>(true));
        // на пост запрос сервер должен гарантировать, что в БД что-то создалось(криэйтед это статус 201 + тело булевый параметр)
        // а если не создасться будет эксепшн
    }

    @PutMapping("/{id}")    // добавляет к основному ресурс следующий, согласно запроса. Пут запрос
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody ProductDto dto, @PathVariable Long id) {
        // с помощью @PathVariable перехватываем id которая в http запросе летит с фронта
        productCrudFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer<>(true));    // возвращаем статус ок., т.е в бади кладем уже
        // не булевое значение, а запрашиваемый объект
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        productCrudFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<ProductDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataContainer<>(productCrudFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<DataContainer<DataTableResponse<ProductDto>>> findAll(
            @RequestParam int page, // принимаем такие http квери параметры, распознаем с помощью  @RequestParam
            @RequestParam int size, // много дублирования кода, если много будет контроллеров
            @RequestParam String sort, // можно все это заменить с помощью утилитки  private WebRequestUtil() { }
            @RequestParam String order) {   // которая внутни себя создает эти параметры, а мы вызываем метод
        DataTableRequest request = new DataTableRequest();  // это показано в ВариантКонтроллере и ИмеджКонтроллере
        request.setPage(page);
        request.setSize(size);
        request.setSort(sort);
        request.setOrder(order);
        return ResponseEntity.ok(new DataContainer<>(productCrudFacade.findAll(request)));
    }
}