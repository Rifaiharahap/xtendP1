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


public class ListviewProfile extends ArrayAdapter<String> {

    private String[] keterangan;
    private Integer[] imgid;
    private Activity context;


    public ListviewProfile(Activity context, String[] keterangan, Integer[] imgid)
    {
        super(context, R.layout.listviewlayout,keterangan);
        this.context=context;
        this.keterangan=keterangan;
        this.imgid=imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder = null;
        if(r==null){


            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listviewlayout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
viewHolder = (ViewHolder) r.getTag();

        }
        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(keterangan[position]);


        return r;


    }

    class ViewHolder{
        TextView tvw1;
        ImageView ivw;
        ViewHolder(View v){
            tvw1= (TextView) v.findViewById(R.id.keterangan);
            ivw = (ImageView) v.findViewById(R.id.imageView);

        }

    }
}
