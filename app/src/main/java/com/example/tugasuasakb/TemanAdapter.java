/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class TemanAdapter extends ArrayAdapter<Teman> {

    Context mCtx;
    int listLayoutRes;
    List<Teman> daftarList;
    SQLiteDatabase mDatabase;

    public TemanAdapter(Context mCtx, int listLayoutRes, List<Teman> daftarList, SQLiteDatabase mDatabase) {
        super(mCtx, listLayoutRes, daftarList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.daftarList = daftarList;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final Teman daftar = daftarList.get(position);


        TextView textViewNim = view.findViewById(R.id.textViewNim);
        TextView textViewNama = view.findViewById(R.id.textViewName);
        TextView textViewKelas = view.findViewById(R.id.textViewKelas);
        TextView textViewTelepon = view.findViewById(R.id.textViewTele);
        TextView textViewEmail = view.findViewById(R.id.textViewEmail);
        TextView textViewSosmed = view.findViewById(R.id.textViewSosmed);


        textViewNim.setText(daftar.getNim());
        textViewNama.setText(daftar.getNama());
        textViewKelas.setText(daftar.getKelas());
        textViewTelepon.setText(daftar.getTelepon());
        textViewEmail.setText(daftar.getEmail());
        textViewSosmed.setText(daftar.getSosmed());


        Button buttonDelete = view.findViewById(R.id.buttonHapusTeman);
        Button buttonEdit = view.findViewById(R.id.buttonUbahTeman);


        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDaftarTeman(daftar);
            }
        });

        //the delete operation
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Hapus Kontak Ini?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM list_teman WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{daftar.getId()});
                        Toast.makeText(mCtx, "Berhasil di Hapus", Toast.LENGTH_SHORT).show();
                        reloadDaftarFromDatabase();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }

    private void updateDaftarTeman(final Teman daftar) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.dialog_update_teman, null);
        builder.setView(view);


        final EditText editTextNim = view.findViewById(R.id.editTextNim);
        final EditText editTextNama = view.findViewById(R.id.editTextName);
        final EditText editTextKelas = view.findViewById(R.id.editTextKelas);
        final EditText editTextTelepon = view.findViewById(R.id.editTextTele);
        final EditText editTextEmail = view.findViewById(R.id.editTextEmail);
        final EditText editTextSosmed = view.findViewById(R.id.editTextSosmed);

        editTextNim.setText(daftar.getNim());
        editTextNama.setText(daftar.getNama());
        editTextKelas.setText(daftar.getKelas());
        editTextTelepon.setText(daftar.getTelepon());
        editTextEmail.setText(daftar.getEmail());
        editTextSosmed.setText(daftar.getSosmed());

        final AlertDialog dialog = builder.create();
        dialog.show();

        view.findViewById(R.id.buttonUbahKontak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim = editTextNim.getText().toString().trim();
                String nama = editTextNama.getText().toString().trim();
                String kelas = editTextKelas.getText().toString().trim();
                String telefon = editTextTelepon.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String sosmed = editTextSosmed.getText().toString().trim();

                if (nim.isEmpty()) {
                    editTextNim.setError("Nim can't be blank");
                    editTextNim.requestFocus();
                    return;
                }

                if (nama.isEmpty()) {
                    editTextNama.setError("Nama can't be blank");
                    editTextNama.requestFocus();
                    return;
                }

                if (kelas.isEmpty()) {
                    editTextKelas.setError("Kelas can't be blank");
                    editTextKelas.requestFocus();
                    return;
                }

                if (telefon.isEmpty()) {
                    editTextTelepon.setError("Telepon can't be blank");
                    editTextTelepon.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    editTextEmail.setError("Email can't be blank");
                    editTextEmail.requestFocus();
                    return;
                }

                if (sosmed.isEmpty()) {
                    editTextSosmed.setError("Sosmed can't be blank");
                    editTextSosmed.requestFocus();
                    return;
                }

                String sql = "UPDATE list_teman \n" +
                        "SET nim = ?, \n" +
                        "nama = ?, \n" +
                        "kelas = ?, \n" +
                        "telepon = ?, \n" +
                        "email = ?, \n" +
                        "sosmed = ? \n" +
                        "WHERE id = ?;\n";

                mDatabase.execSQL(sql, new String[]{nim, nama, kelas, telefon, email, sosmed, String.valueOf(daftar.getId())});
                Toast.makeText(mCtx, "Kontak Berhasil di Update", Toast.LENGTH_SHORT).show();
                reloadDaftarFromDatabase();

                dialog.dismiss();
            }
        });
    }

    private void reloadDaftarFromDatabase() {
        Cursor cursorDaftarLists = mDatabase.rawQuery("SELECT * FROM list_teman", null);
        if (cursorDaftarLists.moveToFirst()) {
            daftarList.clear();
            do {
                daftarList.add(new Teman(
                        cursorDaftarLists.getInt(0),
                        cursorDaftarLists.getString(1),
                        cursorDaftarLists.getString(2),
                        cursorDaftarLists.getString(3),
                        cursorDaftarLists.getString(4),
                        cursorDaftarLists.getString(5),
                        cursorDaftarLists.getString(6)
                ));
            } while (cursorDaftarLists.moveToNext());
        }
        cursorDaftarLists.close();
        notifyDataSetChanged();
    }

}
