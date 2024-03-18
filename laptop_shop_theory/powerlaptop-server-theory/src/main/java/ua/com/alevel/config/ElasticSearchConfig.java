package ua.com.alevel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration  // указываем что это файл конфигурации

// необходима для того чтоб Спринг понимал какой репозиторий к нему обращается
// т.к. у нас подключены разные БД со своими репозиториями
@EnableElasticsearchRepositories("ua.com.alevel.persistence.elasticsearch.repository")
public class ElasticSearchConfig {
}
