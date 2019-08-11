/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;

public class FragmentDaftarTeman extends Fragment {

    @Nullable

    private Button button_coba;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity(), TambahTeman.class);
        getActivity().startActivity(intent);

        return inflater.inflate(R.layout.activity_tambah_teman, container, false);
    }




}