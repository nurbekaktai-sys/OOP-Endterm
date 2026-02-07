package com.workout.management.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // 1. Жалғыз экземпляр (Singleton)
    private static DatabaseConnection instance;
    private Connection connection;

    // 2. Жабық конструктор
    private DatabaseConnection() throws SQLException {
        try {
            // Драйверді тіркеу
            Class.forName("org.postgresql.Driver");

            // Параметрлерді тексеру:
            String url = "jdbc:postgresql://localhost:5432/workout_db"; // workout_db - база аты
            String user = "postgres"; // Постгрестегі логин
            String pass = "1111";     // пароль

            this.connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Мәліметтер базасына сәтті қосылды!");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Драйвер табылмады: " + e.getMessage());
        }
    }

    // 3. Глобалды қолжетімділік нүктесі
    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}