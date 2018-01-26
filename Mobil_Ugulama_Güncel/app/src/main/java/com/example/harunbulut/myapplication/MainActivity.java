package com.example.harunbulut.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends ListActivity {

     veriKaynagi vk ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vk = new veriKaynagi(this);

        vk.ac();
        List<kitap> kitaplar = vk.listele();
        final ArrayAdapter<kitap> adaptor = new ArrayAdapter<kitap>(this,android.R.layout.simple_list_item_1,kitaplar);
        setListAdapter(adaptor);

        final MediaPlayer btnSes = MediaPlayer.create(this, R.raw.butonsesi);


        String isimler [] = {"Dusler Ulkesi","Mai ve Siyah","Suc ve Ceza","Uc Silahsorler","Kelebek"};
        for(int i =0 ;i<5;i++) {
            kitap k = new kitap(isimler[i]);

            int sonid = vk.kitapOlustur(k.getIsim());
          //  vk.kitapOlustur(String.valueOf(k));
        }
        Button ekle = (Button) findViewById(R.id.add);
        Button sil = (Button) findViewById(R.id.delete);
        Button goster = (Button) findViewById(R.id.goster);
        Button katagori =(Button) findViewById(R.id.katagori);
        final EditText textt = (EditText) findViewById(R.id.textBox);
        final EditText text2 = (EditText) findViewById(R.id.textBox2);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String kitapisim = String.valueOf(textt.getText());
                btnSes.start();
                Toast.makeText(MainActivity.this, "Kitap Eklendi", Toast.LENGTH_LONG).show();
                kitap k = new kitap(kitapisim);
                int sonid = vk.kitapOlustur(k.getIsim());
                k.setId(sonid);
                adaptor.add(k);

            }
        });



        textt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textt.setText("");
            }
        });


        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText("");
            }
        });
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // kitap k = (kitap) getListAdapter().getItem(0);
                btnSes.start();
                try {
                    int id = Integer.parseInt(String.valueOf(text2.getText()));
                    for (int i = 0; i < getListAdapter().getCount(); i++) {
                        kitap k = (kitap) getListAdapter().getItem(i);
                        int kitapid = k.getId();
                        if (id == kitapid) {
                            vk.kitapSil(k);
                            adaptor.remove(k);
                            Toast.makeText(MainActivity.this, "Kitabı aldınız Lütfen kayıt Yapın", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                            startActivity(intent);
                        }

                    }
                }catch (Exception e){

                    Toast.makeText(MainActivity.this, "Kitap bulunamadı..", Toast.LENGTH_LONG).show();

                }

               // kitap k = (kitap) getListAdapter().
               //  vk.kitapSil(k);
               //  adaptor.remove(k);
            }
        });

        goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Kayıtlar Gösteriliyor...", Toast.LENGTH_LONG).show();
                btnSes.start();
                try {
                    Bundle extras = getIntent().getExtras();
                    String value = extras.getString("send_string");
                    Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                    i.putExtra("send_string", value);
                    startActivity(i);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Veri bulunamadı..", Toast.LENGTH_LONG).show();

                }


            }
        });


        katagori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(),Main4Activity.class);
                btnSes.start();
                startActivity(intent);

            }
        });


    }
    protected void onResume() {

        vk.ac();
        super.onResume();
    }
    protected void onPause() {
        vk.kapat();
        super.onPause();

    }
}
