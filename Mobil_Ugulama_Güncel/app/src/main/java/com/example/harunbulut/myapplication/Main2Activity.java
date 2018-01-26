package com.example.harunbulut.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity  {
    ListView listeleme;



    public String [] dizi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final MediaPlayer btnSes = MediaPlayer.create(this, R.raw.butonsesi);


        MainActivity deneme = new MainActivity();

        final EditText ad = (EditText) findViewById(R.id.kullanici_adi);
        final EditText soyad = (EditText) findViewById(R.id.kullanici_soyadi);
        final EditText tc_no = (EditText) findViewById(R.id.kullanici_tcno);
        Button kaydet = (Button) findViewById(R.id.kaydet);
         listeleme = (ListView)findViewById(R.id.listeleme);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSes.start();
                ad.setText("");
            }
        });
        soyad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soyad.setText("");
                btnSes.start();
            }
        });
        tc_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tc_no.setText("");
                btnSes.start();
            }
        });
        dizi = new String [1];


        final ArrayAdapter<String> veri = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dizi);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "Bilgileriniz Kaydedildi.", Toast.LENGTH_LONG).show();

                    btnSes.start();

                    dizi[0] = String.valueOf(ad.getText() + " -- " + String.valueOf(soyad.getText()) + " -- " + String.valueOf(tc_no.getText()));

                listeleme.setAdapter(veri);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("send_string",dizi[0]);
                startActivity(i);

            }
        });












        Button geri = (Button) findViewById(R.id.geri);
        geri.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getBaseContext(),MainActivity.class);
               btnSes.start();
               startActivity(intent);
           }
       });

   /*  public void onBackPressed(){

            Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

            this.finish();


    }*/


    //   get.Main2Activity.onBackPressed();


    //  Intent intent = getIntent();
    //List<kullanici> kullanicilar = vk2.listele2();

      /*  Button btn = (Button) findViewById(R.id.kaydet);
        final  EditText txtAd = (EditText) findViewById(R.id.textAd);
        final  EditText txtSoyad = (EditText) findViewById(R.id.textSoyad);
        final  EditText txtTc = (EditText) findViewById(R.id.textTc);
        final  EditText text2 = (EditText) findViewById(R.id.textBox2);
        int id = Integer.parseInt(String.valueOf(text2.getText()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String ad = String.valueOf(txtAd.getText());
               String soyad = String.valueOf(txtSoyad.getText());
               String tc = String.valueOf(txtTc.getText());
               kullanici k = new kullanici(ad,soyad,tc);

            }
        });
*/


    }



}
