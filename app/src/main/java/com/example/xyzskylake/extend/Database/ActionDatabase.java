package com.example.xyzskylake.extend.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xyzskylake.extend.Model.ActionModel;

/**
 * Created by harzen on 19/08/17.
 */

public class ActionDatabase extends DatabaseHelper{

    private String[] data = {Action.ACTION_ID,Action.ACTION_TICKET_ID,Action.ACTION_NAME,Action.ACTION_COMMENT,
                                Action.ACTION_PHOTO,Action.ACTION_DATE};

    public ActionDatabase(Context context){super(context);}

    protected ActionModel actionModel(String where, String[] args, String groupBy, String having, String order, String limit){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Action.TABEL_ACTION,data,where,args,groupBy,having,order,limit);
        ActionModel model = new ActionModel();
        if (cursor.getCount() > 0 ){
            model.setId(cursor.getString(cursor.getColumnIndex(Action.ACTION_ID)));
            model.setTicket_id(cursor.getString(cursor.getColumnIndex(Action.ACTION_TICKET_ID)));
            model.setName(cursor.getString(cursor.getColumnIndex(Action.ACTION_NAME)));
            model.setComment(cursor.getString(cursor.getColumnIndex(Action.ACTION_COMMENT)));
            model.setPhoto(cursor.getString(cursor.getColumnIndex(Action.ACTION_PHOTO)));
            model.setDate(cursor.getLong(cursor.getColumnIndex(Action.ACTION_DATE)));
        }
        cursor.close();
        return model;
    }

    public boolean insert(ActionModel model){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Action.ACTION_ID, model.getId());
        contentValues.put(Action.ACTION_TICKET_ID, model.getTicket_id());
        contentValues.put(Action.ACTION_NAME,model.getName());
        contentValues.put(Action.ACTION_COMMENT,model.getComment());
        contentValues.put(Action.ACTION_PHOTO,model.getPhoto());
        contentValues.put(Action.ACTION_DATE,model.getDate());
        boolean result;
        result = (sqLiteDatabase.insert(Action.ACTION_NAME,null,contentValues) > -1);
        return result;

    }
}
