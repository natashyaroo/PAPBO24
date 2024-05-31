// package com.tokopancing;

// import java.util.ArrayList;
// import java.util.List;

// public class setPancing extends produk {
//     private int idSet;
//     private String namaSet;
//     private String merekSet;
//     private double hargaTotal;
//     private List<produk> produkList;

//     public void SetPancing(int idSet, String namaSet, String merekSet, double hargaTotal) {
//         this.idSet = idSet;
//         this.namaSet = namaSet;
//         this.merekSet = merekSet;
//         this.hargaTotal = hargaTotal;
//         this.produkList = new ArrayList<>();
        
//     }
//     @Override
//     public int getIdProduk() {
//         return idSet;
//     }


//     @Override
//     public String getNama() {
//         return namaSet;
//     }

//     @Override
//     public double getHarga() {
//         return hargaTotal;
//     }

//     public void addProduk(produk produk) {
//         produkList.add(produk);
//     }

//     public List<produk> getProdukList() {
//         return produkList;
//     }

// }
// public class setPancing extends produk {
//     private List<produk> produkList;
//     public joran(int idProduk, String nama, String merek, double harga, String bahan) {
//         super(idProduk, nama, merek, harga);
//         this.bahan = bahan;
//     }

//     public String getBahan(){
//         return bahan;
//     }

//     public void setBahan(String bahan){
//         this.bahan = bahan;
//     }

//     @Override
//     public void tampil() {
//         System.out.println("Joran:");
//         System.out.println("Nama = " + getNama());
//         System.out.println("Merek = " + getMerek());
//         System.out.println("Harga = " + getHarga());
//         System.out.println("Bahan = " + getBahan());
//     }
// }
