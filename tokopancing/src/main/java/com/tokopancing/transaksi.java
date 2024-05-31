package com.tokopancing;

import java.util.ArrayList;
import java.util.List;

public class transaksi {
    private String idTransaksi;
    private String pembeli;
    private List<detailTransaksi> items;
    private double totalPembayaran;

    public transaksi(String idTransaksi, String pembeli) {
        this.idTransaksi = idTransaksi;
        this.pembeli = pembeli;
        this.items = new ArrayList<>();
        this.totalPembayaran = 0.0;
    }

    public void tambahItem(detailTransaksi detail) {
        items.add(detail);
        hitungTotalPembayaran();
    }

    private void hitungTotalPembayaran() {
        totalPembayaran = items.stream().mapToDouble(detailTransaksi::getSubTotalPembayaran).sum();
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getPembeli() {
        return pembeli;
    }

    public List<detailTransaksi> getItems() {
        return items;
    }

    public double getTotalPembayaran() {
        return totalPembayaran;
    }
}
