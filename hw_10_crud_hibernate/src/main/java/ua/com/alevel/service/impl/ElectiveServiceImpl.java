package ua.com.alevel.service.impl;

import ua.com.alevel.dao.ElectivesDao;

import ua.com.alevel.dao.impl.ElectivesDaoImpl;
import ua.com.alevel.entity.Electives;
import ua.com.alevel.service.ElectiveService;

import java.util.Collection;
import java.util.Optional;

public class ElectiveServiceImpl implements ElectiveService {

    private final ElectivesDao electivesDao = new ElectivesDaoImpl();

    @Override
    public boolean create(Electives electives) {
        if (!electivesDao.existByName(electives.getName())) {
            electivesDao.create(electives);
        }
        return false;
    }

    @Override
    public Electives findById(Long id) {
        Optional<Electives> optionalElectives = electivesDao.findById(id);
        if (optionalElectives.isPresent()) {
            return electivesDao.findById(id).get();
        } else {
            throw new SecurityException("Курсу з таким ID не існує!");
        }
    }

    @Override
    public Collection<Electives> findAll() {
        return electivesDao.findAll();
    }
}
