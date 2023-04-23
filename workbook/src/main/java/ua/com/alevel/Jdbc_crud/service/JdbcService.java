package ua.com.alevel.Jdbc_crud.service;

import java.sql.Connection; // пакет - стандарт взаимодействия с БД, а Вендоры обязаны реализовать этот пакет интерфейсов
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcService {      // синглтон
// отвечает за соединение с БД
// прослойка между Dao и Сервером, знает адрес базы и пермишены, централизовано собирает запросы и передает в BD,
// потом возвращает
private static final JdbcService instance = new JdbcService();  // создаем экземпляр этого же класса

    private Connection connection;  // подключает к БД и передает данные
    private Statement statement;    // принимает данные с БД

    private final String driver = "com.mysql.cj.jdbc.Driver"; // нужно загрузить в класс Path, чтоб его видела Джава и знала с какой БД работает
    private final String url = "jdbc:mysql://localhost:3306/java_5";
    private final String username = "root";
    private final String password = "123";

    private JdbcService() {     // приватный конструктор запрещает сделать New из вне, клас должен создать сам себя
        try {
            // сначала наш драйвер загружаем в класс Path и JVM знает что за интерфейс Driver отвечает имплементация com.mysql.cj.jdbc.Driver
            // если много имплементаций одного интерфейса, чтоб jvm понимала какую использовать (чтоб не было конфликта), то
            // нужно указать имя того драйвера (полный путь) с которым она будет работать, через утилиту Class.forName
            Class.forName(driver);
            // теперь DriverManager может раздавать коннекшены, т.к. знает что команду выполнит (имплементирует) конкретный mysql класс
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();   //
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

// публичный метод, чтоб этот класс был виден наружу (getInstance говорит, что это синглтон)
    public static JdbcService getInstance() {
        return instance;
    }

// на уровне jdbc драйвера есть 2 класса связи с BD, это стандартные Джавовые классы
// они интерфейсы, их реализует jdbc драйвер
    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
