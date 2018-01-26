package com.example.harunbulut.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends Activity {
veriKaynagi vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final MediaPlayer btnSes = MediaPlayer.create(this, R.raw.butonsesi);
        SQLiteDatabase db;
       // Listele();
        TextView rapor = (TextView) findViewById(R.id.rapor);
        TextView deger = (TextView) findViewById(R.id.degerler);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("send_string");

        deger.setText(value1+"tc.nolu kisi kutuphaneden kitap aldı.");




        Button geri = (Button) findViewById(R.id.geri);
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
