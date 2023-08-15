package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

// работает с абстрактными объектами, которых может быть много, но через него они все идут в БД
// абстракция позволяет не создавать ДАО слой для каждого объекта отдельно (сокращение кода и времени)
// ElectivesDao уже наследуются от сюда и имеют свои дополнительные уникальные методы в отличие от стандартного набора
// в Спринг эти операции происходят автоматически (нужно отнаследоваться от CrudRepository)
public interface BaseDao<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(E e);   // хайбер удалять по id не умеет
    Optional<E> findById(Long id);
    Collection<E> findAll();
}

//    DataTableResponse<E> findAll(DataTableRequest request); // передаем в качестве параметра
//    DataTableResponse<E> findAll(DataTableRequest request); - реализовать факультеты

