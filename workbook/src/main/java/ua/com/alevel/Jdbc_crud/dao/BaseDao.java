package ua.com.alevel.Jdbc_crud.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;

public interface BaseDao<E extends BaseEntity> {
// универсальный интерфейс, реализует однотипные методы др. классов
// собирает инфо с наследников, создает sql запросы и передает дальше на JdbcService, потом получает ответ
    void create(E e);   // точно знаем что что-то вернется
    void update(E e);   // точно знаем что что-то вернется
    void delete(Long id);   // точно знаем что что-то вернется
    E findById(Long id); // Optional - значит может что-то вернется, может нет (сигнализируем), объекта может и не быть
    Collection<E> findAll();
}