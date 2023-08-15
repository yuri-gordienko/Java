package ua.com.alevel.service;

import ua.com.alevel.entity.Pupils;

import java.util.Collection;

public interface PupilsService { // конкретный класс, работаем с конкретными объектами

    boolean create(Pupils pupils);  // как аргументы указываем конкретные объекты

    void update(Pupils pupils, Long id);

    void delete(Pupils pupils);

    Pupils findById(Long id);

    Collection<Pupils> findAll();
}

