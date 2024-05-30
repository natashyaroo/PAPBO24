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

    public void saveToDB(){
        
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
