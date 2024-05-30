package com.tokopancing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersController {
    private static Connection connection;
    static InputStreamReader isr = new InputStreamReader(System.in);    
    static BufferedReader br = new BufferedReader(isr);
    public usersController(Connection connection) {
        this.connection = connection;
    }
    // tambah data ke database
    public void addUsers(users user) throws SQLException {
        String query = "INSERT INTO users (username, password,role) VALUES (?,?,?)";
        
        try (PreparedStatement preparedStatement =
        
        connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRole());
        preparedStatement.executeUpdate();
        }
    }

    // membaca data pada database berdasarkan id
    public users getUsersById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        try 
            (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try
            (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new users(resultSet.getInt("id"), 
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("role"));
            }
        }
    }
    return null;
    }
    // mengambil semua data akun dari database
    public static void getAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            Main.akunUser.add(new users(
                resultSet.getInt("id_user"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("role"))
            );
        }
        
    }

    // update data pada database
    public static void updateUsers(users user) throws SQLException {
    String query = "UPDATE users SET username = ?, password = ? WHERE id_user = ?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, String.valueOf(user.getId()));
        preparedStatement.executeUpdate();
    }
    }
    // menghapus data dari database
    public static void deleteUsers(int id) throws SQLException {
    String query = "DELETE FROM users WHERE id_user = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    }

    // Register a new user
    public void register(String username, String password, String role) throws SQLException {
        users newUser = new users(0, username, password, role);
        addUsers(newUser);
        Main.akunUser.add(newUser);
    }

    // Login user
    public users login(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new users(resultSet.getInt("id_user"), 
                                        resultSet.getString("username"),
                                        resultSet.getString("password"),
                                        resultSet.getString("role"));
                }
            }
        }
        return null;
    }

    public static void updateUser() throws IOException, SQLException{
        int pilihProduk = Integer.parseInt(br.readLine());
        // System.out.print("Masukkan username: ");
        // Main.akunUser.get(pilihProduk).setUsername(br.readLine());
        deleteUsers(Main.akunUser.get(pilihProduk).getId());
        Main.akunUser.remove(pilihProduk);
        // updateUsers(Main.akunUser.get(pilihProduk));
    }
}