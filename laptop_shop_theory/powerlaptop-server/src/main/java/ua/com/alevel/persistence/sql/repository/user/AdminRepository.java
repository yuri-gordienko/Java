package ua.com.alevel.persistence.sql.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.user.Admin;

@Repository
public interface AdminRepository extends UserRepository<Admin> { }
