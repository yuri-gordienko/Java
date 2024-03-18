package ua.com.alevel.facade.user;

import ua.com.alevel.data.dto.auth.LoginDto;

public interface RegistrationFacade {

    void create(LoginDto dto);
}
