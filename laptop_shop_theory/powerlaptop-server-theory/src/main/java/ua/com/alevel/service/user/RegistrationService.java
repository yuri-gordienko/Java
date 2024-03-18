package ua.com.alevel.service.user;

import ua.com.alevel.persistence.sql.entity.user.Personal;

public interface RegistrationService {

    void create(Personal personal);
}
