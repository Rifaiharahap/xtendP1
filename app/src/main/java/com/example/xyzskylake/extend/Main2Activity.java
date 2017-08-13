package com.example.xyzskylake.extend;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView txthome,txttugas;
    ImageView imghome,imghome2,imgtugas,imgtugas2;
    ListView lst;
    String[] judul = {"Perbaikan Kabel Jaringan Komputer","Pohon Tumbang","Server Terbakar","Gangguan Jaringan","Keamanan Data Hancur"};
    String[] time = {"14 Agustus 2017, 18.00 WIB","15 Agustus 2017, 07.00 WIB","19 Agustus 2017, 20.00 WIB","01 September 2017, 15.00.00 WIB","03 September 2017, 16.00 WIB"};
    String[] keterangan = {"Akibat petir kabelnya jadi gosong","Hujan Deras","Listrik Statis","Kesslahan input data user","Serangan Virus"};

    RelativeLayout home;
    RelativeLayout profile;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imgtugas = (ImageView)findViewById(R.id.imgtugas);
        imgtugas2 = (ImageView)findViewById(R.id.imgtugas2);
        imghome = (ImageView)findViewById(R.id.imghome);
        imghome2 = (ImageView)findViewById(R.id.imghome2);
        txthome=(TextView)findViewById(R.id.txthome) ;
        txttugas=(TextView)findViewById(R.id.txttugas) ;
        home = (RelativeLayout) findViewById(R.id.home);
        profile = (RelativeLayout) findViewById(R.id.profile);
        lst = (ListView) findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this, judul, keterangan,time);
        lst.setAdapter(customListview);

        txthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.VISIBLE);
                if (home.getVisibility() == View.VISIBLE) {
                    profile.setVisibility(View.GONE);
                    imghome2.setVisibility(View.VISIBLE);
                    imghome.setVisibility(View.GONE);
                    imgtugas.setVisibility(View.VISIBLE);
                    imgtugas2.setVisibility(View.GONE);


                }
            }
        });
        txttugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    profile.setVisibility(View.VISIBLE);
                    profile.setVisibility(View.VISIBLE);
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.GONE);
                    imgtugas2.setVisibility(View.VISIBLE);

                }
            }
        });

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.VISIBLE);
                if (home.getVisibility() == View.VISIBLE) {
                    profile.setVisibility(View.GONE);
                    imghome2.setVisibility(View.VISIBLE);
                    imghome.setVisibility(View.GONE);
                    imgtugas.setVisibility(View.VISIBLE);
                    imgtugas2.setVisibility(View.GONE);

                }
            }
        });

        imgtugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    profile.setVisibility(View.VISIBLE);
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.GONE);
                    imgtugas2.setVisibility(View.VISIBLE);


                }
            }
        });



    }
}