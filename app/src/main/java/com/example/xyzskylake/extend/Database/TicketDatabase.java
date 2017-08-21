package com.example.xyzskylake.extend.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xyzskylake.extend.Model.TicketModel;

/**
 * Created by harzen on 19/08/17.
 */

public class TicketDatabase extends DatabaseHelper {

    private String[] data ={Ticket.TABLE_ID,Ticket.TABLE_SUBJECT,Ticket.TABLE_DESCRIPTION,Ticket.TABLE_LAT,
                            Ticket.TABLE_LNG,Ticket.TABLE_RADIUS,Ticket.TABLE_CREATE_DATE,Ticket.TABLE_CREATE_BY};

    public TicketDatabase (Context context){ super(context);}

    private TicketModel ticketModel(String where, String[] args, String groupBy, String having, String order, String limit){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Ticket.TABLE_NAME,data,where,args,groupBy,having,order,limit);
        TicketModel model = new TicketModel();
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            model.setId(cursor.getString(cursor.getColumnIndex(Ticket.TABLE_ID)));
            model.setSubject(cursor.getString(cursor.getColumnIndex(Ticket.TABLE_SUBJECT)));
            model.setDescription(cursor.getString(cursor.getColumnIndex(Ticket.TABLE_DESCRIPTION)));
            model.setLat(cursor.getDouble(cursor.getColumnIndex(Ticket.TABLE_LAT)));
            model.setLng(cursor.getDouble(cursor.getColumnIndex(Ticket.TABLE_LNG)));
            model.setRadius(cursor.getDouble(cursor.getColumnIndex(Ticket.TABLE_RADIUS)));
            model.setCreate_date(cursor.getLong(cursor.getColumnIndex(Ticket.TABLE_CREATE_DATE)));
            model.setCreate_by(cursor.getString(cursor.getColumnIndex(Ticket.TABLE_CREATE_BY)));
        }
        cursor.close();
        return model;
    }
}
