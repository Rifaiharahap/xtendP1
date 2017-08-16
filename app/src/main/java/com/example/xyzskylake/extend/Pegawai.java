package com.example.xyzskylake.extend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.xyzskylake.extend.Listview.CustomListPegawai;

public class Pegawai extends AppCompatActivity {
    ListView lst2;
    String[] namapegawai = {"Perbaikan Pegawai", "Absensi Harian"};
    String[] jabatan = {"Perbaikan jalur kereta api di daera Kota Medan", "Absen hari sabtu"};
    Integer[] imgid = {R.drawable.image1, R.drawable.ic_setting};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pegawai);

        lst2 = (ListView) findViewById(R.id.listview1);
        CustomListPegawai customListPegawai = new CustomListPegawai(this, namapegawai, jabatan, imgid);
        lst2.setAdapter(customListPegawai);
    }
}
