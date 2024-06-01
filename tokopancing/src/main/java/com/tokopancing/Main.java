package com.tokopancing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<users> akunUser = new ArrayList<>();
    public static ArrayList<produk> listProduk = new ArrayList<>();
    public static ArrayList<joran> listJoran = new ArrayList<>();
    public static ArrayList<mataKail> listMataKail = new ArrayList<>();
    public static ArrayList<transaksi> listTransaksi = new ArrayList<>();
    public static ArrayList<detailTransaksi> listDetail = new ArrayList<>();
    public static String currentUser;
    public static void main(String[] args) throws IOException {

            try {
            Connection connection = DatabaseConnection.getConnection();
            controller dataController  = new controller(connection);
            Scanner scanner = new Scanner(System.in);
            //Load set data ke ArrayList
            controller.getAllUsers();
            controller.loadDataJoran();

            while (true) {


                for (int i = 0 ; i < akunUser.size() ; i++){
                    System.out.println("Username : "+akunUser.get(i).getUsername());
                }
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  

                if (option == 1) {
                    // Registration
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    dataController.register(username, password, "pelanggan");
                    System.out.println("User registered successfully!");

                } else if (option == 2) {
                    // Login
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    users user = dataController.login(username, password);
                    if (user != null) {
                        if (user.getRole().equals("pelanggan")) {
                            currentUser = user.getUsername();
                            menuPelanggan mnu = new menuPelanggan();
                            mnu.displayPelangganMenu(user.getUsername());
                        } else if(user.getRole().equals("admin")){
                            menuAdmin adminmenu = new menuAdmin();
                            adminmenu.displayAdminMenu();
                        }else{
                            System.out.println("user not found");
                        }
                    } else {
                        System.out.println("Invalid username or password.");
                    }

                } else if (option == 3) {
                    // Exit
                    System.out.println("Exiting...");
                    break;
                } else if (option == 4) {
                    controller.updateUser();
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            scanner.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}