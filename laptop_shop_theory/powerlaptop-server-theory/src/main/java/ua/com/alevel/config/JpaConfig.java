package ua.com.alevel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration  // указываем что это файл конфигурации
// Спринг стартует приложение - сразу ищет Конфигурейшн классы

// необходима для того чтоб Спринг понимал какой репозиторий к нему обращается
// т.к. у нас подключены разные БД со своими репозиториями
@EnableJpaRepositories("ua.com.alevel.persistence.sql.repository")
public class JpaConfig { }