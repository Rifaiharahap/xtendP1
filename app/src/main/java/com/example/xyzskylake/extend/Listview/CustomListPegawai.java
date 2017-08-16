package com.example.xyzskylake.extend.Listview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xyzskylake.extend.R;

/**
 * Created by XYZ Skylake on 08/08/2017.
 */

public class CustomListPegawai extends ArrayAdapter<String>{
    private Activity context;
    private String[] namapegawai;
    private String [] jabatan;
    private Integer[] imgid;

    public CustomListPegawai(Activity context, String[] namapegawai, String[] jabatan, Integer[] imgid) {
        super(context, R.layout.listview_profil,namapegawai);


        this.context=context;
        this.namapegawai=namapegawai;
        this.jabatan=jabatan;
        this.imgid=imgid;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_profil,null,true );
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(imgid[position]);

        viewHolder.tvw2.setText(jabatan[position]);
        viewHolder.tvw1.setText(namapegawai[position]);
        return r;
    }
    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1 = (TextView) v.findViewById(R.id.namapegawai);
            tvw2 = (TextView) v.findViewById(R.id.jabatan);
            ivw = (ImageView) v.findViewById(R.id.gambar);
        }

    }
}
