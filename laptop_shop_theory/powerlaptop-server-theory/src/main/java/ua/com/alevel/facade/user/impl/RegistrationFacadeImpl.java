package ua.com.alevel.facade.user.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.data.dto.auth.LoginDto;
import ua.com.alevel.facade.user.RegistrationFacade;
import ua.com.alevel.persistence.sql.entity.user.Personal;
import ua.com.alevel.service.user.RegistrationService;

@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final RegistrationService registrationService;

    public RegistrationFacadeImpl(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void create(LoginDto dto) {
        Personal personal = new Personal();
        personal.setUsername(dto.username());
        personal.setPassword(dto.password());
        registrationService.create(personal);
    }
}
