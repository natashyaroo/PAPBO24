package com.tokopancing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbtokopancing"; // Ganti dengan URL database Anda
    private static final String USER = "root"; // Ganti dengan username database Anda
    private static final String PASS = ""; // Ganti dengan password database Anda

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (connection != null) {
                System.out.println("Koneksi ke database berhasil!");
            }
        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database!");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Panggil metode getConnection untuk menguji koneksi
        getConnection();
    }
}
