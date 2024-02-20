package ua.com.alevel.persistence.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.com.alevel.persistence.sql.entity.BaseEntity;

@NoRepositoryBean
public interface BaseEntityRepository<E extends BaseEntity> extends JpaRepository<E, Long> { }
