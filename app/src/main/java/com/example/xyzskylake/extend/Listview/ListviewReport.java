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

import static com.example.xyzskylake.extend.R.id.alamat;
import static com.example.xyzskylake.extend.R.id.imagelogo;
import static com.example.xyzskylake.extend.R.id.photo;
import static com.example.xyzskylake.extend.R.id.tanda;
import static com.example.xyzskylake.extend.R.id.tema;
import static com.example.xyzskylake.extend.R.id.waktu;


public class ListviewReport extends ArrayAdapter<String> {

    private String[] tema;
    private String[] address;
    private String[] waktu;
    private Integer[] photo;
    private Activity context;


    public ListviewReport(Activity context, String[] tema,String[] address,String[] waktu, Integer[] photo)
    {
        super(context, R.layout.listviewreport,tema);
        this.context=context;
        this.tema=tema;
        this.address=address;
        this.waktu=waktu;
        this.photo=photo;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder = null;
        if(r==null){


            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listviewreport,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) r.getTag();

        }
        viewHolder.photoreport.setImageResource(photo[position]);
        viewHolder.textViewreport1.setText(tema[position]);
        viewHolder.textViewreport2.setText(address[position]);
        viewHolder.textViewreport4.setText(waktu[position]);



        return r;


    }

    class ViewHolder{
        TextView textViewreport1;
        TextView textViewreport2;
        TextView textViewreport4;
        ImageView photoreport;
        ViewHolder(View v){
            textViewreport1= (TextView) v.findViewById(R.id.tema);
            textViewreport2= (TextView) v.findViewById(R.id.address);
            textViewreport4= (TextView) v.findViewById(R.id.waktu);
            photoreport = (ImageView) v.findViewById(R.id.photo);

        }

    }
}