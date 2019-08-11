/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class LihatPager extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pager);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPage(this));


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView26:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}