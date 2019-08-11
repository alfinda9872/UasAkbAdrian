/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TambahTeman extends AppCompatActivity implements View.OnClickListener{

    public static final String DATABASE_NAME = "kontak_teman";

    TextView textViewListTeman;
    EditText editTextNim,editTextName, editTextKelas, editTextTele, editTextEmail, editTextSosmed;


    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_teman);

        textViewListTeman = (TextView) findViewById(R.id.textViewListTeman);
        editTextNim = (EditText) findViewById(R.id.editTextNim);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextKelas = (EditText) findViewById(R.id.editTextKelas);
        editTextTele = (EditText) findViewById(R.id.editTextTele);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextSosmed = (EditText) findViewById(R.id.editTextSosmed);



        findViewById(R.id.buttonTambahKontak).setOnClickListener(this);
        textViewListTeman.setOnClickListener(this);

        //creating a database
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_WORLD_READABLE, null);

        createTableDaftarTeman();
    }



    private void createTableDaftarTeman() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS list_teman (\n" +
                        "    id INTEGER NOT NULL CONSTRAINT list_teman_pk PRIMARY KEY AUTOINCREMENT,\n" +
                        "    nim varchar(10) NOT NULL,\n" +
                        "    nama varchar(50) NOT NULL,\n" +
                        "    kelas varhar(50) NOT NULL,\n" +
                        "    telepon varchar(50) NOT NULL,\n" +
                        "    email varchar(50) NOT NULL,\n"+
                        "    sosmed varchar(50) NOT NULL\n"+
                        ");"
        );
    }


    private boolean inputBenar(String nim, String nama, String kelas, String telepon, String email, String sosmed) {
        if (nim.isEmpty()) {
            editTextNim.setError("Masukkan Nim Dulu");
            editTextNim.requestFocus();
            return false;
        }

        if (nama.isEmpty()) {
            editTextName.setError("Masukkan Nama dulu");
            editTextName.requestFocus();
            return false;
        }

        if (kelas.isEmpty()) {
            editTextKelas.setError("Masukkan Kelas dulu");
            editTextKelas.requestFocus();
            return false;
        }

        if (telepon.isEmpty()) {
            editTextTele.setError("Masukkan Nomor Telepon");
            editTextTele.requestFocus();
            return false;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Masukkan Email Dulu");
            editTextEmail.requestFocus();
            return false;
        }

        if (sosmed.isEmpty()) {
            editTextSosmed.setError("Masukkan Sosmed Dulu");
            editTextSosmed.requestFocus();
            return false;
        }


        return true;
    }

    //In this method we will do the create operation
    private void TambahTemankan() {

        String nim = editTextNim.getText().toString().trim();
        String nama = editTextName.getText().toString().trim();
        String kelas = editTextKelas.getText().toString().trim();
        String telepon = editTextTele.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String sosmed = editTextSosmed.getText().toString().trim();

        if (inputBenar(nim, nama, kelas, telepon, email, sosmed)) {

            String insertSQL = "INSERT INTO list_teman \n" +
                    "(nim, nama, kelas, telepon, email, sosmed)\n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?, ?, ?);";


            mDatabase.execSQL(insertSQL, new String[]{nim, nama, kelas, telepon, email, sosmed});
            Toast.makeText(this, "Kontak Teman Berhasil Di Tambah", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTambahKontak:

                TambahTemankan();

                break;
            case R.id.textViewListTeman:

                startActivity(new Intent(this, BottomActivity.class));

                break;
        }
    }
}

