/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/


package com.example.tugasuasakb;

public class Teman {

    int id;
    String nim, nama, kelas, telepon, email, sosmed;

    public Teman(int id, String nim, String nama, String kelas, String telepon, String email, String sosmed){

        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telepon = telepon;
        this.email = email;
        this.sosmed = sosmed;
    }

    public int getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getSosmed() {
        return sosmed;
    }
}
