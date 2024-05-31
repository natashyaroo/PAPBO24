package com.tokopancing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class controller {
    private static Connection connection;
    static InputStreamReader isr = new InputStreamReader(System.in);    
    static BufferedReader br = new BufferedReader(isr);
    public controller(Connection connection) {
        controller.connection = connection;
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

    public static void loadDataJoran() throws SQLException{
        String query = """
            SELECT 
            produk.id_produk, produk.nama, produk.merek, 
            produk.harga, joran.bahan, joran.panjang
            FROM 
                produk
            JOIN 
                joran
            ON 
                produk.id_produk = joran.id_produk; 
            """;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    
        while (resultSet.next()) {
            Main.listJoran.add(new joran(
                resultSet.getString("id_produk"),
                resultSet.getString("nama"),
                resultSet.getString("merek"),
                resultSet.getDouble("harga"),
                resultSet.getString("bahan"),
                resultSet.getDouble("panjang"))
            );
        }
    }
    //!!!!! ubah sesuai data senar
    public static void loadDataSenar() throws SQLException{
        String query = """
            SELECT 
            produk.id_produk, produk.nama, produk.merek, 
            produk.harga, joran.bahan, joran.panjang
            FROM 
                produk
            JOIN 
                joran
            ON 
                produk.id_produk = joran.id_produk; 
            """;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    
        while (resultSet.next()) {
            Main.listJoran.add(new joran(
                resultSet.getString("id_produk"),
                resultSet.getString("nama"),
                resultSet.getString("merek"),
                resultSet.getDouble("harga"),
                resultSet.getString("bahan"),
                resultSet.getDouble("panjang"))
            );
        }
    }
    //!!!!! ubah sesuai data matakail
    public static void loadDataMataKail() throws SQLException{
        String query = """
            SELECT 
            produk.id_produk, produk.nama, produk.merek, 
            produk.harga, joran.bahan, joran.panjang
            FROM 
                produk
            JOIN 
                joran
            ON 
                produk.id_produk = joran.id_produk; 
            """;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    
        while (resultSet.next()) {
            Main.listJoran.add(new joran(
                resultSet.getString("id_produk"),
                resultSet.getString("nama"),
                resultSet.getString("merek"),
                resultSet.getDouble("harga"),
                resultSet.getString("bahan"),
                resultSet.getDouble("panjang"))
            );
        }
    }

    public static void updateJoran(joran jrn)throws SQLException{
        String updateProduk = "UPDATE produk SET nama=?,merek=?,harga=? WHERE id_produk=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateProduk)) {
            preparedStatement.setString(1, jrn.getNama());
            preparedStatement.setString(2, jrn.getMerek());
            preparedStatement.setDouble(3, jrn.getHarga());
            preparedStatement.setString(4, jrn.getIdProduk());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        String updateJoran = "UPDATE joran SET bahan = ?, panjang = ? WHERE id_produk = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateJoran)) {
            preparedStatement.setString(1, jrn.getBahan());
            preparedStatement.setDouble(2, jrn.getPanjang());
            preparedStatement.setString(3, jrn.getIdProduk());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteJoran(joran jrn) {
        String deleteJoranQuery = "DELETE FROM joran WHERE id_produk = ?";
        String deleteProdukQuery = "DELETE FROM produk WHERE id_produk = ?";
        
        try (PreparedStatement deleteJoranStmt = connection.prepareStatement(deleteJoranQuery);
             PreparedStatement deleteProdukStmt = connection.prepareStatement(deleteProdukQuery)) {
            // Delete from joran table
            deleteJoranStmt.setString(1, jrn.getIdProduk());
            deleteJoranStmt.executeUpdate();
    
            // Delete from produk table
            deleteProdukStmt.setString(1, jrn.getIdProduk());
            deleteProdukStmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}