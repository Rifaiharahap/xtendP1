package com.example.xyzskylake.extend.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xyzskylake.extend.Model.UserProfilModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harzen on 18/08/17.
 */

public class UserProfilDatabase extends DatabaseHelper {

    private String[] data = {UserProfil.USER_ID, UserProfil.USER_NAME, UserProfil.USER_EMAIL,
                            UserProfil.USER_DATE_BIRTH, UserProfil.USER_PASSWORD,
                            UserProfil.USER_ADDRESS, UserProfil.USER_PHONE_NUMBER, UserProfil.USER_VERIFICATION,
                            UserProfil.USER_PHOTO, UserProfil.USER_COMPANY_NAME, UserProfil.USER_COMPANY_ADDRESS};

    public UserProfilDatabase(Context context){
        super(context);
    }

    protected UserProfilModel userProfilModel(String where, String[] args, String groupBy, String having, String order, String limit){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(UserProfil.TABEL_NAME,data,where,args,groupBy,having,order,limit);
        UserProfilModel model = new UserProfilModel();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            model.setUuid(cursor.getString(cursor.getColumnIndex(UserProfil.USER_ID)));
            model.setName(cursor.getString(cursor.getColumnIndex(UserProfil.USER_NAME)));
            model.setEmail(cursor.getString(cursor.getColumnIndex(UserProfil.USER_EMAIL)));
            model.setDate_birth(cursor.getLong(cursor.getColumnIndex(UserProfil.USER_DATE_BIRTH)));
            model.setPassword(cursor.getString(cursor.getColumnIndex(UserProfil.USER_PASSWORD)));
            model.setAddress(cursor.getString(cursor.getColumnIndex(UserProfil.USER_ADDRESS)));
            model.setPhone_number(cursor.getString(cursor.getColumnIndex(UserProfil.USER_PHONE_NUMBER)));
            model.setVerification(cursor.getString(cursor.getColumnIndex(UserProfil.USER_VERIFICATION)));
            model.setPhoto(cursor.getString(cursor.getColumnIndex(UserProfil.USER_PHOTO)));
            model.setCompany_name(cursor.getString(cursor.getColumnIndex(UserProfil.USER_COMPANY_NAME)));
            model.setCompany_address(cursor.getString(cursor.getColumnIndex(UserProfil.USER_COMPANY_ADDRESS)));
        }
        cursor.close();
        return model;
    }

    protected List<UserProfilModel> fetchall (String where, String[] args, String groupBy, String having, String order, String limit){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(UserProfil.TABEL_NAME,data,where,args,groupBy,having,order,limit);
        List<UserProfilModel> result = new ArrayList<>();
        if (cursor.getCount()>0){
            cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String uuid = cursor.getString(cursor.getColumnIndex(UserProfil.USER_ID));
                    String name = cursor.getString(cursor.getColumnIndex(UserProfil.USER_NAME));
                    String email = cursor.getString(cursor.getColumnIndex(UserProfil.USER_EMAIL));
                    long date_birth = cursor.getLong(cursor.getColumnIndex(UserProfil.USER_DATE_BIRTH));
                    String password = cursor.getString(cursor.getColumnIndex(UserProfil.USER_PASSWORD));
                    String address = cursor.getString(cursor.getColumnIndex(UserProfil.USER_ADDRESS));
                    String phone = cursor.getString(cursor.getColumnIndex(UserProfil.USER_PHONE_NUMBER));
                    String verification = cursor.getString(cursor.getColumnIndex(UserProfil.USER_VERIFICATION));
                    String photo = cursor.getString(cursor.getColumnIndex(UserProfil.USER_PHOTO));
                    String company_name = cursor.getString(cursor.getColumnIndex(UserProfil.USER_COMPANY_NAME));
                    String company_address = cursor.getString(cursor.getColumnIndex(UserProfil.USER_COMPANY_ADDRESS));
                    UserProfilModel model = new UserProfilModel(uuid,name,email,date_birth,password,address,phone,verification,
                            photo,company_name,company_address);

                    result.add(model);
                    cursor.moveToNext();
                }
        }
        cursor.close();
        return result;
    }

    public boolean insert(UserProfilModel userProfilModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfil.USER_ID,userProfilModel.getUuid());

    }
}