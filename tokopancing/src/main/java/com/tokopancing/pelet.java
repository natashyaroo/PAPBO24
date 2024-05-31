package com.tokopancing;

public class pelet implements fungsilainnya{
    private final String nama;
    private final String merek;
    private final double harga;
    private final String rasa;

    public pelet(String nama, String merek, double harga, String rasa) {
        this.nama = nama;
        this.merek = merek;
        this.harga = harga;
        this.rasa = rasa;
    }

    public String getNama() {
        return nama;
    }

    public String getMerek() {
        return merek;
    }

    public double getHarga() {
        return harga;
    }
    public String getRasa() {
        return rasa;
    }

    @Override
    public void tampil(){
        System.out.println("Merek = " + getMerek());
    }

    @Override
    public void tampil(boolean detail) {
        if (detail){
            System.out.println("Pelet:");
            System.out.println("Nama = " + getNama());
            System.out.println("Harga = " + getHarga());
            System.out.println("Rasa = " + getRasa());
        } else {
            tampil();
        }
    }
};
