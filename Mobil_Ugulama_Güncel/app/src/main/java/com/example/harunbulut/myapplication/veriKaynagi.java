package com.example.harunbulut.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harun Bulut on 25.01.2018.
 */

public class veriKaynagi {
    SQLiteDatabase db;
    sqlite_katmani bdb;

    public veriKaynagi(Context c){

        bdb=new sqlite_katmani(c);
    }
    public void ac(){
        db= bdb.getWritableDatabase();

    }
    public void kapat(){

        bdb.close();
    }


    public int kitapOlustur(String isim){
       // String isim ="Vadideki Zambak";
       // kitap k = new kitap();
        //k.setIsim(isim);
        ContentValues val = new ContentValues();
        val.put("isim",isim);
        int sonid= (int)db.insert("kitap",null,val);
        return sonid;
    }

    public void kitapSil(kitap k){
        int id = k.getId();
        db.delete("kitap","id="+id,null);


    }


    public List<kitap> listele(){
        String kolonlar[] = {"id","isim"};
        List<kitap> liste = new ArrayList<kitap>();
        Cursor c = db.query("kitap",kolonlar,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            int id = c.getInt(0);
            String isim =c.getString(1);
           // String eleman = ""+id+"-"+isim;
            kitap k = new kitap(isim,id);
           // k.setIsim(isim);
            //k.setId(id);
            liste.add(k);
            c.moveToNext();

        }
        c.close();
        return liste;
    }
}
