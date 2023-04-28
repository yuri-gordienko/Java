package ua.com.alevel.service;

import ua.com.alevel.entity.Pupils;

import java.util.Collection;

public interface PupilsService {

    boolean create(Pupils pupils);

    void update(Pupils pupils, Long id);

    void delete(Pupils pupils);

    Pupils findById(Long id);

    Collection<Pupils> findAll();
}

