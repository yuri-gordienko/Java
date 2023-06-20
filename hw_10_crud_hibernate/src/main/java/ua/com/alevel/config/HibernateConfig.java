package ua.com.alevel.config;

// Настройки в .pom файле:
// name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver - подгружаем jdbc.Driver
// name="hibernate.connection.url">jdbc:mysql://localhost:3306/java_5 - прописываем адрес
// name="hibernate.connection.username">root
// name="hibernate.connection.password">123
// name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect - подсказывем хайбернейт на каком диалекте будет общаться
// name="hibernate.hbm2ddl.auto">update - обновляем БД (если Create создает новую, СreateDrop - удаляет существующую и создает новую)
// name="hibernate.current_session_context_class">org.hibernate.context.internal.ThreadLocalSessionContext - бъясняем Хайбернейту кто следит за сессиями, т.е.
// указываем что конкретный класс будет отвечать за реализацию сессии (connection), в данном случае каждая сессия это новый поток
// name="hibernate.show_sql">true - будет показывать в консоле хронологию запросов в sql на Хайбернейтовском языке
// name="hibernate.enable_lazy_load_no_trans">true - т.к ученики подтянуты к факультативам и наоборот, чтоб не было замкнутого круга (ошибки) при расппечатке
// Хайбер обрубает эту связь (при обращении к коллекции энтитей внутри какой-то энтити), поэтому чтоб распечатать нужен lazy_load - подтянет только одну связь

// <mapping class="ua.com.alevel.entity.Electives"/> - Объясняем какие классы ему Мапить:
// <mapping class="ua.com.alevel.entity.Pupils"/>

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// class HibernateConfig необходим для загрузки настроек из .pom файла
// можно и без него, но будет много ручной работы
public class HibernateConfig {

    private final SessionFactory sessionFactory; // клас синглтон, будет раздавать сессии (connections)
    private static HibernateConfig instance = new HibernateConfig(); // по конвенциям Синглтон называют - instance

    private HibernateConfig() {     // приватный конструктор
        Configuration configuration = new Configuration();  // инициализируем Session fabric, для это используем класс Configuration
        configuration.configure("hibernate.cfg.xml");   // передаем наш файл с настройками
        sessionFactory = configuration.buildSessionFactory(); // инициализируем Session fabric
    }

    public static HibernateConfig getInstance() {   // метод возвращает наш HibernateConfig
        if (instance == null) {
            instance = new HibernateConfig();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
