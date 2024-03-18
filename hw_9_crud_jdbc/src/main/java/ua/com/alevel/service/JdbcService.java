package ua.com.alevel.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcService {

private static final JdbcService instance = new JdbcService();

    private Connection connection;
    private Statement statement;

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String username = "root";
    private final String password = "javajava";

    private JdbcService() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();   //
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static JdbcService getInstance() {

        return instance;
    }

    public Connection getConnection() {

        return connection;
    }

    public Statement getStatement() {

        return statement;
    }
}
