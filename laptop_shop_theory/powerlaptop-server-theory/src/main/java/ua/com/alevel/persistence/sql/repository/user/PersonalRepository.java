package ua.com.alevel.persistence.sql.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.user.Personal;

@Repository
public interface PersonalRepository extends UserRepository<Personal> { }
