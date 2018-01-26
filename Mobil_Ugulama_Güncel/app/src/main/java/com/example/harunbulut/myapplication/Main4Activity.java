package com.example.harunbulut.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class Main4Activity extends AppCompatActivity {
    ListView liste;
    ListView liste2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        final MediaPlayer btnSes = MediaPlayer.create(this, R.raw.butonsesi);

        Button gizem =(Button)findViewById(R.id.gizem);
        Button polisiye =(Button) findViewById(R.id.polisiye);
        Button ask =(Button) findViewById(R.id.ask);
        Button edebiyat =(Button) findViewById(R.id.edebiyat);
         liste = (ListView) findViewById(R.id.liste);
         liste2 = (ListView)findViewById(R.id.liste2);
        String [] dizi1 = {"Baslangic               Sayfa Sayisi:", "Olasiliksiz              Sayfa Sayisi:", "Golun Evi                Sayfa Sayisi:", "Karanlik Sular         Sayfa Sayisi:", "Kirmizi Pazartesi    Sayfa Sayisi:"};
        String [] dizi2 = {"Sherlock Holmes      Sayfa  Sayisi:","Cerrah                         Sayfa  Sayisi:","Siyah Kan                   Sayfa  Sayisi:","Ejdarha Dovme Kiz   Sayfa  Sayisi:","Gunahkar                    Sayfa  Sayisi:"};
        String [] dizi3 = {"Kurk Mantolu Madonna  Sayfa Sayisi:","Ask ve Gurur                     Sayfa Sayisi:","Senden Once Ben             Sayfa Sayisi:","Beyaz Geceler                   Sayfa Sayisi:","Eylul                                    Sayfa Sayisi:"};
        String [] dizi4 = {"Abum Rabum                    Sayfa Sayisi:","Huzursuzluk                      Sayfa Sayisi:","Konusan Oykuler               Sayfa Sayisi:","Kanadi Kirik Kuslar            Sayfa Sayisi:","Kirmizi Piyano                    Sayfa Sayisi:"};

        final ArrayAdapter<String> veri1= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dizi1);
        final ArrayAdapter<String> veri2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dizi2);
        final ArrayAdapter<String> veri3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dizi3);
        final ArrayAdapter<String> veri4 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dizi4);

        String[] a=new String[5];
        String[] b=new String[5];
        String[] c=new String[5];
        String[] d=new String[5];


        Random random = new Random();

        for(int i=0;i<5;i++) {
            a[i] = String.valueOf (random.nextInt(500));

            while ((Integer.parseInt(a[i])) < 200){
                a[i] = String.valueOf (random.nextInt(500));
            }
        }
        for(int i=0;i<5;i++) {
            b[i] = String.valueOf (random.nextInt(500));

            while ((Integer.parseInt(b[i])) < 200) {
                b[i] = String.valueOf (random.nextInt(500));
            }
        }
        for(int i=0;i<5;i++) {
            c[i] = String.valueOf (random.nextInt(500));

            while ((Integer.parseInt(c[i])) < 200) {
                c[i] = String.valueOf (random.nextInt(500));
            }
        }
        for(int i=0;i<5;i++) {
            d[i] = String.valueOf (random.nextInt(500));

            while ((Integer.parseInt(d[i])) < 200) {
                d[i] = String.valueOf (random.nextInt(500));
            }
        }
        final ArrayAdapter<String> veri5= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        final ArrayAdapter<String> veri6 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,b);
        final ArrayAdapter<String> veri7 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,c);
        final ArrayAdapter<String> veri8 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,d);



        gizem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main4Activity.this, "Gizem Türü Kitaplar", Toast.LENGTH_LONG).show();
                btnSes.start();
                liste.setAdapter(veri1);
                liste2.setAdapter(veri5);
            }
        });

        polisiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main4Activity.this, "Polisiye Türü Kitaplar", Toast.LENGTH_LONG).show();
                btnSes.start();
                liste.setAdapter(veri2);
                liste2.setAdapter(veri6);
            }
        });

        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main4Activity.this, "Aşk Türü Kitaplar", Toast.LENGTH_LONG).show();
                btnSes.start();
                liste.setAdapter(veri3);
                liste2.setAdapter(veri7);
            }
        });

        edebiyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main4Activity.this, "Edebiyat Türü Kitaplar", Toast.LENGTH_LONG).show();
                btnSes.start();
                liste.setAdapter(veri4);
                liste2.setAdapter(veri8);
            }
        });

















        Button geri =(Button) findViewById(R.id.geri);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                btnSes.start();
                startActivity(intent);

            }
        });





    }
}
