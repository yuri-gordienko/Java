package ua.com.alevel.persistence.sql.repository.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.user.User;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

import java.util.Optional;

@Repository // это у нас репа, потому что есть такая таблица
// важная аннотация - это дженерик, принимает энтити и айдишник, в Спринговый репозиторий можем передать только энтити (таблицу)
// когда будем из БД тащить всех Юзеров findAll, то вытащит всех юзеров, а когда будем тащить персоналов, то вытащит только персоналов без админов
// т.е только тех у кого Дискриминотор персонал, удобно чтоб не делать отдельный sql запрос

public interface UserRepository<U extends User> extends BaseEntityRepository<U> {
    // UserRepository<U extends User> дженерик - некто U, который extends User
    // и закидываем его в BaseEntityRepository<U>, который наследуется от jpa репозитория - persistence.sql.repository

    Optional<U> findByUsername(String username); // возвращает наследника какого-то Юзера

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.enabled = true")
    Optional<U> findActiveByUsername(@Param("username") String username);

    boolean existsByUsername(String email); // необходимо для регистрации
}
