package com.example.xyzskylake.extend;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by XYZ Skylake on 07/08/2017.
 */

public class CustomListview extends ArrayAdapter<String> {
    private String[] judul;
    private String[] keterangan;
    private Integer[] imgid;
    private Activity context;
    public CustomListview(Activity context, String[] judul,String[] keterangan,Integer[] imgid) {
        super(context, R.layout.listview_layout,judul);


        this.context=context;
        this.judul=judul;
        this.keterangan=keterangan;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true );
            viewHolder= new ViewHolder(r);
             r.setTag(viewHolder);
        }
     else{
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(judul[position]);
        viewHolder.tvw2.setText(keterangan[position]);
        return r;
    }
    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1 = (TextView) v.findViewById(R.id.judul);
            tvw2 = (TextView) v.findViewById(R.id.keterangan);
            ivw = (ImageView) v.findViewById(R.id.gambar);
        }

    }
}
