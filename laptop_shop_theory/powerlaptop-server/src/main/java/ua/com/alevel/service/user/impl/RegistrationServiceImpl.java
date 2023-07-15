package ua.com.alevel.service.user.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.exception.UserExistException;
import ua.com.alevel.persistence.sql.entity.user.Personal;
import ua.com.alevel.persistence.sql.repository.user.PersonalRepository;
import ua.com.alevel.service.user.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final PersonalRepository personalRepository;
    private final PasswordEncoder encoder;

    public RegistrationServiceImpl(PersonalRepository personalRepository, PasswordEncoder encoder) {
        this.personalRepository = personalRepository;
        this.encoder = encoder;
    }

    @Override
    public void create(Personal personal) {
        if (personalRepository.existsByUsername(personal.getUsername())) {
            throw new UserExistException("Username already exists");
        }
        personal.setPassword(encoder.encode(personal.getPassword()));
        personalRepository.save(personal);
    }
}
