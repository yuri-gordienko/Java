package ua.com.alevel.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// class HibernateConfig необходим для загрузки настроек из файла конфигурации
// можно и без него, но будет много ручной работы
public class HibernateConfig {

    private final SessionFactory sessionFactory; // клас синглтон, будет раздавать сессии (connections)
    private static HibernateConfig instance = new HibernateConfig(); // по конвенциям Синглтон называют - instance

    private HibernateConfig() {     // приватный конструктор
        Configuration configuration = new Configuration();  // инициализируем Session fabric, для это используем класс Configuration
        configuration.configure("hibernate.cfg.xml");   // передаем наш файл с настройками
        sessionFactory = configuration.buildSessionFactory(); // инициализируем Session fabric
    }

    public static HibernateConfig getInstance() {   // метод возвращает наш HibernateConfig, чтоб был виден из вне
        if (instance == null) {
            instance = new HibernateConfig();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() { // делаем геттер на сешнфабрику

        return sessionFactory;
    }
}
