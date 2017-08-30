package com.example.xyzskylake.extend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.xyzskylake.extend.Listview.CustomListview;
import com.example.xyzskylake.extend.Listview.ListviewProfile;
import com.example.xyzskylake.extend.Listview.ListviewReport;
import com.example.xyzskylake.extend.Listview.ListviewUrgent;
import com.example.xyzskylake.extend.Maps.DetailTicket;

public class HomeActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ImageView imghome,imghome2,imgtugas,imgtugas2,imgprofile,imgurgent2;//Deklarasi Image View
    Button btnreport,btnlist,btnurgent;
    ListView lst2;
    ListView lst;
    ListView listreport;
    ListView listurgent;

    String[] judul = {"Perbaikan Kabel Fiber"};//untuk listview list
    String[] alamat = {"Jalan Iskandar Muda No.07","Jalan Sisingamangaraja No.08","Jalan Gagak Hitam No.101","Jalan Cempaka No.05"}; //untuk listview list
    String[] time = {"20:00","10:00","15:00","17:00"};//untuk listview list
    Integer[] status={R.drawable.waiting};//untuk listview list




    String[] judulurgent = {"Perbaikan Kabel Fiber Urgent"};//untuk listview Urgent
    String[] addressurgent = {"Jalan Sultan No.01","Jalan Protokol No.15"};//untuk listview Urgent
    String[] timeurgent = {"20:00","10:00","15:00","17:00"};//untuk listview Urgent
    Integer[] statusurgent={R.drawable.urgent};//untuk listview Urgent



    String[] tema = {"Pemasangan CCTV","Perbaikan Rel Kereta Api"};//untuk listview Report
    String[] address = {"Jalan Sultan No.01","Jalan Protokol No.15"};//untuk listview Report
    String[] waktu = {"20:00","15:00"};//untuk listview Report
    Integer[] photo={R.drawable.cctv,R.drawable.kereta};//untuk listview Report

    String[] tanda={"Rantauprapat, 07 August 1996","Jalan Ika Bina No.07 Rantau Prapat","rifaiharahap7@gmail.com","Secret","Logout"};
    Integer[] imagelogo={R.drawable.ic_lahir,R.drawable.ic_tempat,R.drawable.ic_mail,R.drawable.ic_password,R.drawable.logout};



    RelativeLayout home;//Relative untuk home
    RelativeLayout tugas; //Relative untuk assignment
    RelativeLayout profile;//Relative Untuk profile
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);


        progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.setInverseBackgroundForced(false);

        listurgent = (ListView) findViewById(R.id.listurgent);// Menghubungkan ke urgent Listview
        ListviewUrgent listviewUrgent=new ListviewUrgent(this,judulurgent,addressurgent,timeurgent,statusurgent);
        listurgent.setAdapter(listviewUrgent);

        listreport = (ListView) findViewById(R.id.listreport);
        ListviewReport listviewReport=new ListviewReport(this,tema,address,waktu,photo);
        listreport.setAdapter(listviewReport);

        lst2 = (ListView) findViewById(R.id.listprofile);
        ListviewProfile listviewProfile=new ListviewProfile(this,tanda,imagelogo);
        lst2.setAdapter(listviewProfile);
        btnreport= (Button) findViewById(R.id.btnreport);
        btnlist= (Button) findViewById(R.id.btnlist);
        btnurgent= (Button) findViewById(R.id.btnurgent);
        imgurgent2 = (ImageView)findViewById(R.id.imgurgent2);
        imgprofile = (ImageView)findViewById(R.id.imgprofile);
        imgtugas = (ImageView)findViewById(R.id.imgtugas);
        imgtugas2 = (ImageView)findViewById(R.id.imgtugas2);
        imghome = (ImageView)findViewById(R.id.imghome);
        imghome2 = (ImageView)findViewById(R.id.imghome2);
        home = (RelativeLayout) findViewById(R.id.home);
        tugas = (RelativeLayout) findViewById(R.id.tugas);
        profile = (RelativeLayout) findViewById(R.id.profile);
        lst = (ListView) findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this, judul, alamat,time,status);
        lst.setAdapter(customListview);

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.VISIBLE);
                if (home.getVisibility() == View.VISIBLE) {
                    tugas.setVisibility(View.GONE);
                    imghome2.setVisibility(View.VISIBLE);
                    imghome.setVisibility(View.GONE);
                    imgtugas.setVisibility(View.VISIBLE);
                    imgtugas2.setVisibility(View.GONE);
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    profile.setVisibility(View.GONE);

                }
            }
        });

        imgtugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    tugas.setVisibility(View.VISIBLE);
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.GONE);
                    imgtugas2.setVisibility(View.VISIBLE);
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    profile.setVisibility(View.GONE);
                    btnlist.setBackgroundColor(Color.parseColor("#1E88E5"));


                }
            }
        });
        imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    tugas.setVisibility(View.GONE);
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.VISIBLE);
                    imgtugas2.setVisibility(View.GONE);
                    imgprofile.setVisibility(View.GONE);
                    imgurgent2.setVisibility(View.VISIBLE);
                    profile.setVisibility(View.VISIBLE);

                }
            }
        });
        btnreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.GONE);
                    imgtugas2.setVisibility(View.VISIBLE);
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    profile.setVisibility(View.GONE);
                    listreport.setVisibility(View.VISIBLE);
                    lst.setVisibility(View.GONE);
                    listurgent.setVisibility(View.GONE);
                    btnurgent.setBackgroundColor(Color.parseColor("#2196F3"));
                    btnreport.setBackgroundColor(Color.parseColor("#1E88E5"));
                    btnlist.setBackgroundColor(Color.parseColor("#2196F3"));

                }
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.GONE);
                    imgtugas2.setVisibility(View.VISIBLE);
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    profile.setVisibility(View.GONE);
                    listreport.setVisibility(View.GONE);
                    listurgent.setVisibility(View.GONE);
                    lst.setVisibility(View.VISIBLE);

                    btnurgent.setBackgroundColor(Color.parseColor("#2196F3"));
                    btnlist.setBackgroundColor(Color.parseColor("#1E88E5"));
                    btnreport.setBackgroundColor(Color.parseColor("#2196F3"));

                }
            }
        });
        btnurgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setVisibility(View.GONE);
                if (home.getVisibility() == View.GONE) {
                    imghome2.setVisibility(View.GONE);
                    imghome.setVisibility(View.VISIBLE);
                    imgtugas.setVisibility(View.GONE);
                    imgtugas2.setVisibility(View.VISIBLE);
                    imgprofile.setVisibility(View.VISIBLE);
                    imgurgent2.setVisibility(View.GONE);
                    profile.setVisibility(View.GONE);
                    listreport.setVisibility(View.GONE);
                    listurgent.setVisibility(View.VISIBLE);
                    lst.setVisibility(View.GONE);

                    btnlist.setBackgroundColor(Color.parseColor("#2196F3"));
                    btnurgent.setBackgroundColor(Color.parseColor("#1E88E5"));
                    btnreport.setBackgroundColor(Color.parseColor("#2196F3"));
                }
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                progressDialog.show();
                //Intent showmap = new Intent(HomeActivity.this, DetailTicket)
                startActivity(new Intent(HomeActivity.this,DetailTicket.class));
                dismiss();
            }
        });
    }

    public void dismiss(){
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}