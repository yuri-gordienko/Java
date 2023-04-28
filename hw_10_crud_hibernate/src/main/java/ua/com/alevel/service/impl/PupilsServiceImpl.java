package ua.com.alevel.service.impl;

import ua.com.alevel.dao.PupilsDao;
import ua.com.alevel.dao.impl.PupilsDaoImpl;
import ua.com.alevel.entity.Pupils;
import ua.com.alevel.service.PupilsService;

import java.util.Collection;
import java.util.Optional;

public class PupilsServiceImpl implements PupilsService {

    private final PupilsDao pupilsDao = new PupilsDaoImpl();

    @Override
    public boolean create(Pupils pupils) {
        if (!pupilsDao.existByEmail(pupils.getEmail())) {
            pupilsDao.create(pupils);
        }
        return false;
    }

    @Override
    public void update(Pupils pupils, Long id) {
        Optional<Pupils> optionalPupils = pupilsDao.findById(id);
        if (optionalPupils.isPresent()) {
            pupils.setId(id);
            pupilsDao.update(pupils);
        } else {
            System.out.println("Перевірте введенні данні.");
        }
    }

    @Override
    public void delete(Pupils pupils) {
        pupilsDao.delete(pupils);
    }

    @Override
    public Pupils findById(Long id) {
        Optional<Pupils> optionalPupils = pupilsDao.findById(id);
        if (optionalPupils.isPresent()) {
            return pupilsDao.findById(id).get();
        } else {
            throw new SecurityException("Студента з таким ID не існує!");
        }
    }

    @Override
    public Collection<Pupils> findAll() {
        return pupilsDao.findAll();
    }
}
