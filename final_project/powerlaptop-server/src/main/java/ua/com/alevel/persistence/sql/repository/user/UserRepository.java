package ua.com.alevel.persistence.sql.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.com.alevel.persistence.sql.entity.user.User;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Optional;

@Repository
public interface UserRepository<U extends User> extends BaseEntityRepository<U> {

    Optional<U> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.enabled = true")
    Optional<U> findActiveByUsername(@Param("username") String username);

    boolean existsByUsername(String email);
}
