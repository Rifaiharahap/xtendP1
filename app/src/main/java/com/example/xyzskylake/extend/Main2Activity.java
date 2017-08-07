package com.example.xyzskylake.extend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    ListView lst;
    String[] judul={"Tugas Pokok", "Absensi Harian"};
    String[] keterangan={"Tugas hari ini melaksanakan design","Absen hari sabtu"};
    Integer[] imgid ={R.drawable.ic_profile,R.drawable.ic_setting};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        lst= (ListView) findViewById(R.id.listview);
CustomListview customListview=new CustomListview(this,judul,keterangan,imgid);
        lst.setAdapter(customListview);

    }
}
