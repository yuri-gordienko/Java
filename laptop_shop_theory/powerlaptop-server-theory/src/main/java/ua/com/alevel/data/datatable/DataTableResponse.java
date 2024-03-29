package ua.com.alevel.data.datatable;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import ua.com.alevel.data.dto.BaseDto;
import ua.com.alevel.persistence.sql.entity.BaseEntity;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class DataTableResponse<DTO extends BaseDto> { // класс, который возвращает сформированый ответ из БД на фронт

    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    private boolean first;
    private boolean last;
    private boolean next;
    private boolean previous;
    private String sort;
    private String order;
    private Collection<DTO> items;

    // конструктором назначаем значения для филдов класса DataTableResponse
    // из DataTableRequest request - принимаем данные с фронта для инициализации полей page, size, sort, order
    // из Джавового интерфейса Page вытягиваем остальные стандартные методы для этого класса
    public <E extends BaseEntity> DataTableResponse(DataTableRequest request, Page<E> page) {
        this.page = request.getPage();  // это Ешки
        this.size = request.getSize();
        this.sort = request.getSort();
        this.order = request.getOrder();
        this.totalPages = page.getTotalPages(); // это тянем из Пейджи
        this.totalElements = page.getTotalElements();
        this.first = page.isFirst();
        this.last = page.isLast();
        this.next = page.hasNext();
        this.previous = page.hasPrevious();
        this.items = new ArrayList<>();
    }
}