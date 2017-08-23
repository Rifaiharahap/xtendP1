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

import static com.example.xyzskylake.extend.R.id.imagelogo;
import static com.example.xyzskylake.extend.R.id.tanda;


public class ListviewProfile extends ArrayAdapter<String> {

    private String[] tanda;
    private Integer[] imagelogo;
    private Activity context;


    public ListviewProfile(Activity context, String[] tanda, Integer[] imagelogo)
    {
        super(context, R.layout.listviewlayout,tanda);
        this.context=context;
        this.tanda=tanda;
        this.imagelogo=imagelogo;

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
        viewHolder.ivw2.setImageResource(imagelogo[position]);
        viewHolder.tvw2.setText(tanda[position]);


        return r;


    }

    class ViewHolder{
        TextView tvw2;
        ImageView ivw2;
        ViewHolder(View v){
            tvw2= (TextView) v.findViewById(R.id.tanda);
            ivw2 = (ImageView) v.findViewById(R.id.imagelogo);

        }

    }
}
