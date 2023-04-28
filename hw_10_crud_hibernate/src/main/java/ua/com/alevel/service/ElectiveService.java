package ua.com.alevel.service;

import ua.com.alevel.entity.Electives;

import java.util.Collection;

public interface ElectiveService {

    boolean create(Electives electives);

    Electives findById(Long id);

    Collection<Electives> findAll();
}
