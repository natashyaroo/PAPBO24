package com.tokopancing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class menuPelanggan {
    InputStreamReader isr = new InputStreamReader(System.in);    
    BufferedReader br = new BufferedReader(isr);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void promptEnterKey() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("  ║            Tekan \"ENTER\" untuk Melanjutkan...        ║");
        System.out.println("  ╚════════════════════════════════════════════════════════╝");
        
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
        }
    }

    public void displayPelangganMenu(){
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
                        
                        promptEnterKey();
                        continue;
                    }
            if (pilih.equals("1")){

            }else if(pilih.equals("2")){

            }else if(pilih.equals("3")){

            }else if (pilih.equals("4")) {
                
            }else if(pilih.equals("0")){
                 break;
            }

        }
            

    }
}
