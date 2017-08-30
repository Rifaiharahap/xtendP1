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



public class CustomListview extends ArrayAdapter<String> {
    private String[] judul;
    private String[] alamat;
    private String[] time;
    private Integer[] status;
    private Activity context;
    public CustomListview(Activity context, String[] judul,String[] alamat, String[] time,Integer[] status) {
        super(context, R.layout.listview_ticket,judul);


        this.context=context;
        this.judul=judul;
        this.alamat=alamat;
        this.time=time;
        this.status=status;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_ticket,null,true );
            viewHolder= new ViewHolder(r);
             r.setTag(viewHolder);
        }
     else{
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.tvw1.setText(judul[position]);
        viewHolder.tvw2.setText(alamat[position]);
        viewHolder.tvw3.setText(time[position]);
        viewHolder.status.setImageResource(status[position]);
        return r;
    }
    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        ImageView status;
        ViewHolder(View v)
        {
            tvw1 = (TextView) v.findViewById(R.id.judul);
            tvw2 = (TextView) v.findViewById(R.id.alamat);
            tvw3 = (TextView) v.findViewById(R.id.time);
            status=(ImageView)v.findViewById(R.id.status);
        }

    }
}
