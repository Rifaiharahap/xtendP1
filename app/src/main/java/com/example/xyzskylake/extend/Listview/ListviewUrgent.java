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



public class ListviewUrgent extends ArrayAdapter<String> {
    private String[] judulurgent;
    private String[] addressurgent;
    private String[] timeurgent;
    private Integer[] statusurgent;
    private Activity context;
    public ListviewUrgent(Activity context, String[] judulurgent,String[] addressurgent, String[] timeurgent,Integer[] statusurgent) {
        super(context, R.layout.listviewurgent,judulurgent);


        this.context=context;
        this.judulurgent=judulurgent;
        this.addressurgent=addressurgent;
        this.timeurgent=timeurgent;
        this.statusurgent=statusurgent;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listviewurgent,null,true );
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.judulurgent.setText(judulurgent[position]);
        viewHolder.addressurgent.setText(addressurgent[position]);
        viewHolder.timeurgent.setText(timeurgent[position]);
        viewHolder.statusurgent.setImageResource(statusurgent[position]);
        return r;
    }
    class ViewHolder
    {
        TextView judulurgent;
        TextView addressurgent;
        TextView timeurgent;
        ImageView statusurgent;
        ViewHolder(View v)
        {
            judulurgent = (TextView) v.findViewById(R.id.judulurgent);
            addressurgent = (TextView) v.findViewById(R.id.addressurgent);
            timeurgent = (TextView) v.findViewById(R.id.timeurgent);
            statusurgent=(ImageView)v.findViewById(R.id.statusurgent);
        }

    }
}
