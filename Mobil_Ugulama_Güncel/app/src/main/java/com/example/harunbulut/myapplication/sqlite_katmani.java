package com.example.harunbulut.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Harun Bulut on 25.01.2018.
 */

public class sqlite_katmani extends SQLiteOpenHelper{

    public sqlite_katmani(Context c){

        super(c,"kitap",null, 1);

    }

    public void onCreate(SQLiteDatabase db){


        String sql = "create table kitap (id integer primary key autoincrement"+ ",isim text not null)";
        db.execSQL(sql);

    }
    public void onUpgrade(SQLiteDatabase db,int eski, int yeni){
        db.execSQL("drop table if exists kitap");

    }
}

