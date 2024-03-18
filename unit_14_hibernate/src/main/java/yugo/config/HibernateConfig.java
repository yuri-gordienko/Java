package yugo.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

//    клас відповідає за підключення до БД (створення сесії), тобто роздає конекшени як у jdbc. Він сінглтон
//    sessionFactory - змінна, з якою будемо працювати далі
    private final SessionFactory sessionFactory;

//    створюемо екземпляр класу
    private static HibernateConfig instance = new HibernateConfig();

//    приватний конструктор
    private HibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
//    щоб звертатися до методів сінглтон класу, через змінну instance
    public static HibernateConfig getInstance() {
        return instance;
    }

//    повертаємо сесію
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
