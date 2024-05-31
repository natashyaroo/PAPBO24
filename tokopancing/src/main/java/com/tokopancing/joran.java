package com.tokopancing;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class joran extends produk {
    private String bahan ;
    private double panjang ;
    public joran(String idProduk, String nama, String merek, double harga, String bahan, double panjang) {
        super(idProduk, nama, merek, harga);
        this.bahan = bahan;
        this.panjang = panjang;
    }


    @Override
    public void tampil() {
        System.out.println("Nama = " + getNama());
        System.out.println("Merek = " + getMerek());
        System.out.println("Harga = " + getHarga());
        System.out.println("Bahan = " + getBahan());
    }

    public void saveToDB() {
        try (Connection conn = DatabaseConnection.getConnection()){
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO produk (id_produk,nama, merek, harga) VALUES (?,?, ?, ?)")) {
                pstmt.setString(1, getIdProduk());
                pstmt.setString(2, getNama());
                pstmt.setString(3, getMerek());
                pstmt.setDouble(4, getHarga());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO joran (id_produk, bahan,panjang) VALUES (?, ?,?)")) {
                pstmt.setString(1, getIdProduk());
                pstmt.setString(2, getBahan());
                pstmt.setDouble(3,getPanjang());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDb(){

    }

    public String getBahan(){
        return bahan;
    }
    public double getPanjang() {
        return panjang;
    }
    public void setBahan(String bahan){
        this.bahan = bahan;
    }
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }   

}