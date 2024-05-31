package com.tokopancing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mataKail extends produk {
    private double ukuran;
    public mataKail(String idProduk, String nama, String merek, double harga, double ukuran) {
        super(idProduk,nama, merek, harga);
        this.ukuran = ukuran;
    }

    public double getUkuran(){
        return ukuran;
    }

    public void setUkuran(double ukuran){
        this.ukuran = ukuran;
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
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO matakail (id_produk, ukuran) VALUES (?, ?)")) {
                pstmt.setString(1, getIdProduk());
                pstmt.setDouble(2, getUkuran());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tampil() {
        System.out.println("Mata Kail:");
        System.out.println("Nama = " + getNama());
        System.out.println("Merek = " + getMerek());
        System.out.println("Harga = " + getHarga());
        System.out.println("Ketebalan = " + getUkuran());
    }
    public void tampil(boolean detail){

    }

}
