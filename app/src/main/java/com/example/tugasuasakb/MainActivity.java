/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading=4000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent halamanutama=new Intent(MainActivity.this, LihatPager.class);
                startActivity(halamanutama);
                finish();

            }
        },waktu_loading);
    }
}

/*
        Tanggal Pengerjaan : 18-05-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/