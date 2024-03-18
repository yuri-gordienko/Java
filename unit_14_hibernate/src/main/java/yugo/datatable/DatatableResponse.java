package yugo.datatable;

import yugo.dao.BaseDao;
import yugo.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class DatatableResponse<E extends BaseEntity> {

//    повинен мати всі філди, що і у Реквесті + додаткові для коректрої роботи, а саме:
//    треба сказати загальну кількість сторінок, також Найменувань і повернути Ліст Найменувань
    private int page;
    private int size;
    private String orderBy;
    private String sortBy;
    private int totalPages;
    private long totalItems;
    private List<E> items;

//    конструктором назначаємо умови
    public DatatableResponse() {
        this.items = new ArrayList<>();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
}
