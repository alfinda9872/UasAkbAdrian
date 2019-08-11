/*
        Tanggal Pengerjaan : 11-08-2019
        Nim : 10116172
        Nama : Adrian Syahputra Alfinda
        Kelas : IF-4 (AKB-4) >

*/



package com.example.tugasuasakb;

public enum ModelObject {


    GREEN(R.string.green, R.layout.view_page),
    BLUE(R.string.blue, R.layout.view_page2);



    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}