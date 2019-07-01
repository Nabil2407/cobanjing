package com.example.k.Model;

public class Modelwilayah {
    String id,namakabupatenterpilih,namakecamatan,namawilayah,detailwilayah;
    double luaslahan,nilair;

    public Modelwilayah(String id, String namakabupatenterpilih, String namakecamatan, String namawilayah, String detailwilayah, double luaslahan, double nilair) {
        this.id = id;
        this.namakabupatenterpilih = namakabupatenterpilih;
        this.namakecamatan = namakecamatan;
        this.namawilayah = namawilayah;
        this.detailwilayah = detailwilayah;
        this.luaslahan = luaslahan;
        this.nilair = nilair;
    }

    public String getId() {
        return id;
    }

    public String getNamakabupatenterpilih() {
        return namakabupatenterpilih;
    }

    public String getNamakecamatan() {
        return namakecamatan;
    }

    public String getNamawilayah() {
        return namawilayah;
    }

    public String getDetailwilayah() {
        return detailwilayah;
    }

    public double getLuaslahan() {
        return luaslahan;
    }

    public double getNilair() {
        return nilair;
    }
}
