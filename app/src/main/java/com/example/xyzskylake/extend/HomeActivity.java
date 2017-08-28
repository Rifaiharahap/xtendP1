package com.example.xyzskylake.extend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.xyzskylake.extend.Listview.CustomListview;
import com.example.xyzskylake.extend.Listview.ListviewProfile;
import com.example.xyzskylake.extend.Maps.DetailTicket;

public class HomeActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView imghome,imghome2,imgtugas,imgtugas2,imgprofile,imgurgent2;
    ListView lst2;
    ListView lst;
    String[] judul = {"Perbaikan Kabel Jaringan Komputer","Pohon Tumbang","Server Terbakar","Gangguan Jaringan","Keamanan Data Bermassalah"};
    String[] time = {"14 Agustus 2017, 18.00 WIB","15 Agustus 2017, 07.00 WIB","19 Agustus 2017, 20.00 WIB","01 September 2017, 15.00.00 WIB","03 September 2017, 16.00 WIB"};
    String[] keterangan = {"Akibat petir kabelnya jadi gosong","Hujan Deras","Listrik Statis","Kesslahan input data user","Serangan Virus"};
    String[] tanda={"Rantauprapat, 07 August 1996","Jalan Ika Bina No.07 Rantau Prapat","rifaiharahap7@gmail.com","Secret","Logout"};
    Integer[] imagelogo={R.drawable.ic_lahir,R.drawable.ic_tempat,R.drawable.ic_mail,R.drawable.ic_password,R.drawable.logout};
    RelativeLayout home;
    RelativeLayout profile;
    RelativeLayout person;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);


        progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.setInverseBackgroundForced(false);

        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }

        lst2 = (ListView) findViewById(R.id.listprofile);
        ListviewProfile listviewProfile=new ListviewProfile(this,tanda,imagelogo);
        lst2.setAdapter(listviewProfile);
        imgurgent2 = (ImageView)findViewById(R.id.imgurgent2);
        imgprofile = (ImageView)findViewById(R.id.imgprofile);
        imgtugas = (ImageView)findViewById(R.id.imgtugas);
        imgtugas2 = (ImageView)findViewById(R.id.imgtugas2);
        imghome = (ImageView)findViewById(R.id.imghome);
        imghome2 = (ImageView)findViewById(R.id.imghome2);
        home = (RelativeLayout) findViewById(R.id.home);
        profile = (RelativeLayout) findViewById(R.id.profile);
        person = (RelativeLayout) findViewById(R.id.person);
        lst = (ListView) findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this, judul, keterangan,time);
        lst.setAdapter(customListview);

        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }

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
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    person.setVisibility(View.GONE);

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
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    person.setVisibility(View.GONE);


                }
            }
        });
        imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    profile.setVisibility(View.VISIBLE);
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.VISIBLE);
                    imgtugas2.setVisibility(View.GONE);
                    imgprofile.setVisibility(View.GONE);
                    imgurgent2.setVisibility(View.VISIBLE);
                    person.setVisibility(View.VISIBLE);

                }
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                progressDialog.show();
                //Intent showmap = new Intent(HomeActivity.this, DetailTicket)
                startActivity(new Intent(HomeActivity.this,DetailTicket.class));
            }
        });
    }
}