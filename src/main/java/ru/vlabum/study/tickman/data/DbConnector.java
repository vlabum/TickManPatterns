package ru.vlabum.study.tickman.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String URL = "jdbc:h2:~/test";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            registerDriver();
            try {
                connection = DriverManager.getConnection(URL, "sa", "");
            } catch (SQLException e) {
                System.err.println("Ошибка установления соединения: " + e.getMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
        return connection;
    }

    private static void registerDriver() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException e) {
            System.err.println("Ошибка регистрации драйвера: " + e.getMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        }
    }

    public static void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.err.println("Ошибка: " + e.getMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        }
    }
}
