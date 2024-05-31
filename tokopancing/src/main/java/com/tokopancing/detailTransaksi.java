package com.tokopancing;

public class detailTransaksi {
    private String idTransaksi;
    private String idProduk;
    private String namaProduk;
    private double hargaProduk;
    private int jumlahProduk;
    private double subTotalPembayaran;

    public detailTransaksi(String idTransaksi, String idProduk, String namaProduk, double hargaProduk, int jumlahProduk) {
        this.idTransaksi = idTransaksi;
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.jumlahProduk = jumlahProduk;
        this.subTotalPembayaran = hargaProduk * jumlahProduk;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public double getHargaProduk() {
        return hargaProduk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public double getSubTotalPembayaran() {
        return subTotalPembayaran;
    }
}
