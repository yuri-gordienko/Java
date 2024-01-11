package yugo.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// клас Сінглтон створюється лише в одному екземплярі і йому можна тільки раз зробити New
// через нього остальні клас будут підеднуватися до БД, тільки вім має пермішен працювати з базою
// це дозволяє дотримуватися ACID принципів, злагодженність транзакцій, відсутність накладок і суперечностей
public class JdbcConnector {

//  вендори пишуть драйвери (jdbc) у нашому випадку, які взаємодіють через інтерфейси (API) Connection і Statement
//  Connection підключає до БД, відповідає за void методи (create, update, delete)
//  Statement видає дані і обробляємо, відповідає за sql селект методи до бази (select)
    private Connection connection;
    private Statement statement;

//  для доступу до бази, необхідно в ClassPath надати наши пермішени
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String userName = "root";
    private final String password = "javajava";

//  приватний конструктор, для того щоб не можливо було зробити New(екземпляр цього класу) із зовнє,
//  а якщо б конструктор був public, то можна було би створити екземпляр класу
//  функція даного конструктора, щоб не можна було робити New
//  в Class.forName кладемо (driver - API для спілкування на одній мові з натівною мовою sql)
//  за підʼєднання відповідає DriverManager, куди ми надаємо наши пермішени
//  потім створюємо statement
    private JdbcConnector() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

//  а щоб зробити екземпляр класу і наш клас запрацював, запускаємо його прямо в цьому класі
//  таким чином отримуємо публічний клас, який має метод, що роздає сесії
//  змінну instance як правило присвоюють Сінглтон класам
    private static final JdbcConnector instance = new JdbcConnector();

//  публічний метод (по суті геттер) буде роздавати сесії, getInstanse говорить, підказує що клас Синглтон
//  ця змінна необхідна для виклику методів connection і statement з інших класів (наприклад, EmployeeDaoImpl), тому що
//  ми там не можемо сворити екземпляр класу JdbcConnector, а звертатися до методів необхідно через екземпляри класу
    public static JdbcConnector getInstance() {
        return instance;
    }

//  видаємо сесії
    public Connection getConnection() {
        return connection;
    }

//  видаємо сесії
    public Statement getStatement() {
        return statement;
    }
}
