package com.tokopancing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


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

    // ArrayList<produk> listProduk , ArrayList<joran> listJoran
    public void displayAdminMenu() throws IOException, SQLException{
        while (true) {
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
                        String idProduk = UUID.randomUUID().toString();
                        joran newjoran = new joran(idProduk,nama, merek, harga,bahan,panjang);
                        Main.listJoran.add(newjoran);
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
                ubahJoran(br);
            }else if (pilih.equals("4")) {
                deleteJoran(br);
            }else if(pilih.equals("0")){
                 break;
            }
        }
            
    }
    public void displayProduk() throws IOException {
    System.out.println("════════════════ List Joran ════════════════════");
    displayJoran();
    promptEnterKey(br);
    System.out.println("════════════════ List MataKail ════════════════════");
    //!! tolong tambahkan
    promptEnterKey(br);
    System.out.println("════════════════ List Senar ════════════════════");
    //!! tolong tambahkan
    promptEnterKey(br);
    }
    public static void displayJoran(){
        for (int i = 0; i < Main.listJoran.size(); i++) {
            System.out.println("[]"+(i+1)+".]"+"══════════════════════════════════════════════");
            System.out.println("Nama    = " + Main.listJoran.get(i).getNama());
            System.out.println("Merek   = " + Main.listJoran.get(i).getMerek());
            System.out.println("Harga   = " +"Rp "+ Main.listJoran.get(i).getHarga());
            System.out.println("Bahan   = " + Main.listJoran.get(i).getBahan());
            System.out.println("Panjang = " + Main.listJoran.get(i).getPanjang()+" inch");
            System.out.println("════════════════════════════════════════════════");
        }  
    }

    public static void ubahJoran(BufferedReader br) throws IOException,SQLException {
        clearScreen();
        displayJoran();
        System.out.print("╔══════════════════════════════════════════════════════════╗\n");
        System.out.print("║ Pilih Nomor Joran yang ingin diubah:                     ║\n");
        System.out.print("╚══════════════════════════════════════════════════════════╝\n");

        int choice = Integer.parseInt(br.readLine()) - 1;
        if (choice >= 0 && choice < Main.listJoran.size()) {
            System.out.print("╔══════════════════════════════════════════════════════════╗\n");
            System.out.print("║ Masukkan Nama Baru Joran =                               ║\n");
            System.out.print("╚══════════════════════════════════════════════════════════╝\n");
            String nama = br.readLine();
            System.out.print("╔══════════════════════════════════════════════════════════╗\n");
            System.out.print("║ Masukkan Merek Baru Joran =                              ║\n");
            System.out.print("╚══════════════════════════════════════════════════════════╝\n");
            String merek = br.readLine();
            System.out.print("╔══════════════════════════════════════════════════════════╗\n");
            System.out.print("║ Masukkan Harga Baru Joran =                              ║\n");
            System.out.print("╚══════════════════════════════════════════════════════════╝\n");
            double harga = Double.parseDouble(br.readLine());
            System.out.print("╔══════════════════════════════════════════════════════════╗\n");
            System.out.print("║ Masukkan Bahan Joran Baru =                              ║\n");
            System.out.print("╚══════════════════════════════════════════════════════════╝\n");
            String bahan = br.readLine();
            System.out.print("╔══════════════════════════════════════════════════════════╗\n");
            System.out.print("║ Masukkan Panjang Baru Joran =                              ║\n");
            System.out.print("╚══════════════════════════════════════════════════════════╝\n");
            double panjang = Double.parseDouble(br.readLine());
            joran joranToUpdate = Main.listJoran.get(choice);
            //update array list
            joranToUpdate.setNama(nama);
            joranToUpdate.setMerek(merek);
            joranToUpdate.setHarga(harga);
            joranToUpdate.setBahan(bahan);
            joranToUpdate.setPanjang(panjang);
            //update database menggunakan fungsi
            controller.updateJoran(joranToUpdate);

            System.out.println("\n╔════════════════════════════════════════════════════════╗");
            System.out.println(  "║             Data Joran Berhasil Diubah!                ║");
            System.out.println(  "╚════════════════════════════════════════════════════════╝");
            promptEnterKey(br);
        } else {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║                Nomor Joran Tidak Valid!                ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            promptEnterKey(br);
        }
    }
    
    public void deleteJoran(BufferedReader br) throws IOException{
        clearScreen();
        displayJoran();
        System.out.print("╔══════════════════════════════════════════════════════════╗\n");
        System.out.print("║ Pilih Nomor Joran yang ingin dihapus =                   ║\n");
        System.out.print("╚══════════════════════════════════════════════════════════╝\n");
        int choice = Integer.parseInt(br.readLine()) - 1;

        if (choice >= 0 && choice < Main.listJoran.size()) {
            controller.deleteJoran(Main.listJoran.get(choice));
            Main.listJoran.remove(choice);
            System.out.println("\n╔════════════════════════════════════════════════════════╗");
            System.out.println(  "║             Data Joran Berhasil Diubah!                ║");
            System.out.println(  "╚════════════════════════════════════════════════════════╝");
            promptEnterKey(br);
        } else {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║                Nomor joran Tidak Valid!                ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            promptEnterKey(br);
        }
    }
    


}