package com.tokopancing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class menuAdmin {
    InputStreamReader isr = new InputStreamReader(System.in);    
    BufferedReader br = new BufferedReader(isr);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void promptEnterKey(BufferedReader br) throws IOException {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("  ║            Tekan \"ENTER\" untuk Melanjutkan...        ║");
        System.out.println("  ╚════════════════════════════════════════════════════════╝");
        br.readLine();
    }


    public void displayAdminMenu() throws IOException{
        while (true) {
            System.out.println("Menu Utama");
            System.out.println("1. Tampilkan produk");
            System.out.println("2. Beli produk");
            System.out.println("3. Pembayaran");
            System.out.println("4. Riwayat Transaksi");
            System.out.println("0. Logout");
            clearScreen();
            System.out.println("""
                ╔════════════════════════════════════════════════╗
                ║              === Toko Pancing ===              ║
                ║  1. Tambah Data Barang                         ║
                ║  2. Lihat Data Barang                          ║
                ║  3. Ubah Data Barang                           ║
                ║  4. Hapus Data Barang                          ║
                ║  5. Exit                                       ║
                ╚════════════════════════════════════════════════╝
                    """);
                    System.out.print("╔══════════════════════════╗\n");
                    System.out.print("║   Pilih Menu =           ║\n");
                    System.out.print("╚══════════════════════════╝\n");
                    String pilih;
                    try {
                        pilih = br.readLine();
                    } catch (IOException e) {
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║  Terjadi kesalahan saat membaca input! ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        
                        promptEnterKey(br);
                        continue;
                    }
            if (pilih.equals("1")){
                while (true) {
                    clearScreen();
                    System.out.println("""
                        ╔═══════════════════════════════╗
                        ║           Pilih Barang        ║
                        ╠═══════════════════════════════╣
                        ║   1. Joran                    ║
                        ║   2. Mata Kail                ║
                        ║   3. Pelet                    ║
                        ║   0. Kembali                  ║
                        ╚═══════════════════════════════╝
                        """);
    
                        System.out.print("╔══════════════════════════════════════════╗\n");
                        System.out.print("║ Pilih Barang Yang Ingin Ditambahkan =    ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        String tambahAlat = br.readLine();
                    if (tambahAlat.equals("1")) {
                        clearScreen();
                        System.out.print("╔══════════════════════════════════════════╗\n");
                        System.out.print("║ Masukkan Nama Joran      =               ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");

                        String nama = br.readLine();
                        System.out.print("╔══════════════════════════════════════════╗\n");
                        System.out.print("║ Masukkan Merek Joran  =              ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        String merek = br.readLine();
                        System.out.print("╔══════════════════════════════════════════╗\n");
                        System.out.print("║ Masukkan Harga Joran  =              ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        double harga = Double.parseDouble(br.readLine());
                        System.out.print("╔══════════════════════════════════════════╗\n");
                        System.out.print("║ Masukkan bahan Mata Kail  =            ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        String bahan = br.readLine();
                        System.out.print("╔══════════════════════════════════════════╗\n");
                        System.out.print("║ Masukkan panjang Joran  =              ║\n");
                        System.out.print("╚══════════════════════════════════════════╝\n");
                        double panjang = Double.parseDouble(br.readLine());
                        joran newjoran = new joran("",nama, merek, harga,bahan,panjang);
                        // Simpan ke database
                        newjoran.saveToDB();
                        System.out.println("\n╔══════════════════════════════════════════╗");
                        System.out.println("  ║   Data Barang Berhasil Ditambahkan!      ║");
                        System.out.println("  ╚══════════════════════════════════════════╝");
                        promptEnterKey(br);
                    } else if (tambahAlat.equals("2")) {
                        // clearScreen();
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Nama Mata Kail  =               ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");

                        // String nama = br.readLine();
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Merek Mata Kail  =              ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");
                        // String merek = br.readLine();
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Harga Mata Kail  =              ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");
                        // double harga = Double.parseDouble(br.readLine());
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Ukuraan Mata Kail  =            ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");
                        // double ukuran = Double.parseDouble(br.readLine());
                        // mataKail mataKailbaru = new mataKail(0,nama, merek, harga,ukuran);
                        // mataKail.add(mataKailbaru);
                        // System.out.println("\n╔══════════════════════════════════════════╗");
                        // System.out.println("  ║   Data Barang Berhasil Ditambahkan!      ║");
                        // System.out.println("  ╚══════════════════════════════════════════╝");
                        // promptEnterKey();
                    } else if (tambahAlat.equals("3")) {
                        // clearScreen();
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Nama Pelet  =                   ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");

                        // String nama = br.readLine();
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Merek Pelet  =                  ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");
                        // String merek = br.readLine();
                        // System.out.print("╔══════════════════════════════════════════╗\n");
                        // System.out.print("║ Masukkan Harga Pelet  =                  ║\n");
                        // System.out.print("╚══════════════════════════════════════════╝\n");
                        // double harga = Double.parseDouble(br.readLine());
                        // pelet peletbaru = new pelet(nama, merek, harga);
                        // pelet.add(peletbaru);
                        // System.out.println("\n╔══════════════════════════════════════════╗");
                        // System.out.println("  ║   Data Barang Berhasil Ditambahkan!      ║");
                        // System.out.println("  ╚══════════════════════════════════════════╝");
                        // promptEnterKey();

                    } else if (tambahAlat.equals("0")) {
                        break;
                    }
                }
            }else if(pilih.equals("2")){
                displayProduk();
                promptEnterKey(br);
            }else if(pilih.equals("3")){
                displayProduk();
                
            }else if (pilih.equals("4")) {
                
            }else if(pilih.equals("0")){
                 break;
            }
        }
            
    }
    public void displayProduk() {
    System.out.println("=== display produk ===");
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT produk.id_produk, produk.nama, produk.merek, produk.harga, joran.bahan, joran.panjang " +
                "FROM produk " +
                "INNER JOIN joran ON produk.id_produk = joran.id_produk");
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String idProduk = rs.getString("id_produk");
                String nama = rs.getString("nama");
                String merek = rs.getString("merek");
                double harga = rs.getDouble("harga");
                String bahan = rs.getString("bahan");
                double panjang = rs.getDouble("panjang");

                System.out.println("ID Produk: " + idProduk + ", Nama: " + nama +
                                   ", Merek: " + merek + ", Harga: " + harga +
                                   ", Bahan: " + bahan + ", Panjang: " + panjang);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}