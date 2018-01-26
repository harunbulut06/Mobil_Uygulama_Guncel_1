package com.example.harunbulut.myapplication;

/**
 * Created by Harun Bulut on 25.01.2018.
 */

public class kitap {
    String isim;
    int id;


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
    public kitap(String isim) {
        this.isim = isim;

    }
    public kitap(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }

   public String toString (){
       return ""+id+"-"+isim;


   }
}
