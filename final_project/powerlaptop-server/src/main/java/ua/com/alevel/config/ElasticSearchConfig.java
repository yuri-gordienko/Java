package ua.com.alevel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("ua.com.alevel.persistence.elasticsearch.repository")
public class ElasticSearchConfig { }
