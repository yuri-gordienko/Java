package ua.com.alevel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // корневой тест-класс, создается автоматически при генерации приложения через Springititializer
public class PowerlaptopServerApplicationTest {

    @Test   // тест - заглушка, проверка что тесты запускаются, точка входа в систему (как SpringBootApplication.run)
    void contextLoads() { }
}
