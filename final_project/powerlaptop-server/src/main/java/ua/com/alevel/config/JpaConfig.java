package ua.com.alevel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ua.com.alevel.persistence.sql.repository")
public class JpaConfig { }
