package ua.com.alevel.persistence.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.com.alevel.persistence.sql.entity.BaseEntity;

@NoRepositoryBean // это класс не Бин
public interface BaseEntityRepository<E extends BaseEntity> extends JpaRepository<E, Long> { }
// в Спpинге вместо ДАО слоя - Репозиторий слой, работает с какой-то энтити наследнком Бейсэнтити
// JpaRepository - автоматически подключается к БД и не надо создавать Connection i Statement как в JDBC
// или же SessionFactory как в Hibernate
