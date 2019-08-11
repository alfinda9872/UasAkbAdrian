/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListTeman extends AppCompatActivity {

    List<Teman> temanList;
    SQLiteDatabase mDatabase;
    ListView listViewNakama;
    TemanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_teman);

        listViewNakama = (ListView) findViewById(R.id.listViewNakama);
        temanList = new ArrayList<>();


        mDatabase = openOrCreateDatabase(TambahTeman.DATABASE_NAME, MODE_PRIVATE, null);

        showKontakFromDatabase();
    }

    private void showKontakFromDatabase() {
        Cursor cursorTeman = mDatabase.rawQuery("SELECT * FROM list_teman", null);


        if (cursorTeman.moveToFirst()) {

            do {

                temanList.add(new Teman(
                        cursorTeman.getInt(0),
                        cursorTeman.getString(1),
                        cursorTeman.getString(2),
                        cursorTeman.getString(3),
                        cursorTeman.getString(4),
                        cursorTeman.getString(5),
                        cursorTeman.getString(6)
                ));
            } while (cursorTeman.moveToNext());
        }

        cursorTeman.close();


        adapter = new TemanAdapter(this, R.layout.list_layout_teman, temanList, mDatabase);


        listViewNakama.setAdapter(adapter);
    }

}

