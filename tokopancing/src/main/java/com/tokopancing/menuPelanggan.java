package com.tokopancing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class menuPelanggan {
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

    public void displayPelangganMenu(String username) throws IOException{
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
                    ║  1. Tampilkan Produk                           ║
                    ║  2. Beli Produk                                ║
                    ║  3. Pembayaran                                 ║
                    ║  4. Riwayat Transaksi                          ║
                    ║  0. Logout                                     ║
                    ╚════════════════════════════════════════════════╝
                    """);
                    System.out.print("Pilih Menu = ");
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

            }else if(pilih.equals("2")){
                String idTransaksi = UUID.randomUUID().toString();
                transaksi newTransaksi = new transaksi(idTransaksi,username);
                while (true) {
                    System.out.println("++=====         Menu Beli Barang      ====++");
                    System.out.println("|| 1. Joran  |  3. MataKail               ||");
                    System.out.println("|| 2. Senar  |  4. Konfirmasi Pembayaran  ||");
                    System.out.println("|| 3. Pelet  |  0. Kembali                ||");
                    System.out.print("Pilih Menu = ");
                    String pilihPembelian;
                    try {
                        pilihPembelian = br.readLine();
                    } catch (IOException e) {
                        System.out.println(" Terjadi kesalahan saat membaca input! ");
                        promptEnterKey(br);
                        continue;
                    }
                    if (pilihPembelian.equals("1")) {
                        menuAdmin.displayJoran();
                        int choice = Integer.parseInt(br.readLine()) - 1;
                        if (choice >= 0 && choice < Main.listJoran.size()) {      
                        while (true) {
                            System.out.print("Masukan Jumlah Joran: ");
                            Integer jmlhJoran;
                            try {
                                jmlhJoran = Integer.parseInt(br.readLine());
                                if (jmlhJoran <= 0) {
                                    System.out.println("Jumlah joran harus lebih dari 0!");
                                    continue;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid! Harap masukkan angka.");
                                continue;
                            } catch (IOException e) {
                                System.out.println("Terjadi kesalahan saat membaca input!");
                                continue;
                            }

                            detailTransaksi detail = new detailTransaksi(newTransaksi.getIdTransaksi(), Main.listJoran.get(choice).getIdProduk(),  Main.listJoran.get(choice).getNama(), Main.listJoran.get(choice).getHarga(),jmlhJoran);   
                            newTransaksi.tambahItem(detail);
                            Main.listDetail.add(detail);
                            break; 
                            }
                        } else {
                            System.out.println("╔════════════════════════════════════════════════════════╗");
                            System.out.println("║                Nomor Joran Tidak Valid!                ║");
                            System.out.println("╚════════════════════════════════════════════════════════╝");
                            promptEnterKey(br);
                        }
                        
                    } else if(pilihPembelian.equals("2")) {
                        
                    } else if(pilihPembelian.equals("3")) {
                        
                    } else if(pilihPembelian.equals("4")) {
                        while (true) {
                            System.out.println("Simpan Transaksi [ y/t ] : ");
                            System.out.print("Pilih Menu = ");
                            String konfirmasiTransaki;
                            try {
                                konfirmasiTransaki = br.readLine().toLowerCase();
                            } catch (IOException e) {
                                System.out.println(" Terjadi kesalahan saat membaca input! ");
                                promptEnterKey(br);
                                continue;
                            }
                            if (konfirmasiTransaki.equals("y")) {
                                Main.listTransaksi.add(newTransaksi);
                                break;
                            } else if(konfirmasiTransaki.equals("t")) {
                                Main.listTransaksi.remove(newTransaksi);
                                break;  
                            }
                        }
                        System.out.println("Silahkan Lihat Menu Pembayaran Anda");
                        break;
                    } else if(pilihPembelian.equals("0")) {
                        break;
                    }
                }
            }else if(pilih.equals("3")){
                displayTransaksi();
            }else if (pilih.equals("4")) {
                
            }else if(pilih.equals("0")){
                 break;
            }

        }
    }

    private void displayTransaksi()throws IOException {
        for(transaksi Transaksi : Main.listTransaksi){
            if (Transaksi.getPembeli().equals(Main.currentUser)){
                System.out.println("ID Transaksi: " + Transaksi.getIdTransaksi());
                System.out.println("Pembeli: " + Transaksi.getPembeli());
                
                System.out.println("Detail Transaksi:");
                for (detailTransaksi detail : Transaksi.getItems()) {
                    System.out.println(" - " + detail.getNamaProduk() + " x " + detail.getJumlahProduk() + " = " + detail.getSubTotalPembayaran());
                }

                System.out.println("\nTotal Pembayaran: Rp " + Transaksi.getTotalPembayaran());
                promptEnterKey(br);
            }
            // else{
            //     System.out.println("belum memiliki transaksi");
            //     promptEnterKey(br);
            // }
        }
    }
}
