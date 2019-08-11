/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTampil extends Fragment {
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.activity_fragment_tampil, container, false);

        Button buttonPut = (Button) view.findViewById(R.id.buttonInput);
        Button buttonLi = (Button) view.findViewById(R.id.buttonLihat);
        buttonPut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent inta = new Intent(getActivity(), TambahTeman.class);
                startActivity(inta);
            }
            });

        buttonLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intas = new Intent(getActivity(), ListTeman.class);
                startActivity(intas);
            }
        });

        return view;
    }
}
