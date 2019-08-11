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
import android.content.Intent;
import android.widget.Button;



public class FragmentProfil extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profil, null);
        Button button = (Button) v.findViewById(R.id.button_logout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preferences.clearLoggedInUser(getActivity().getBaseContext());
                startActivity(new Intent(getActivity().getBaseContext(),LoginActivity.class));
                getActivity().finish();
            }
        });


        return v;





    }


}
