package com.example.xyzskylake.extend.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xyzskylake.extend.Model.UserProfileModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harzen on 18/08/17.
 */

public class UserProfileDatabase extends DatabaseHelper {

    private String[] data = {UserProfile.USER_ID, UserProfile.USER_NAME, UserProfile.USER_EMAIL,
                            UserProfile.USER_DATE_BIRTH, UserProfile.USER_PASSWORD,
                            UserProfile.USER_ADDRESS, UserProfile.USER_PHONE_NUMBER, UserProfile.USER_VERIFICATION,
                            UserProfile.USER_PHOTO, UserProfile.USER_COMPANY_NAME, UserProfile.USER_COMPANY_ADDRESS};

    public UserProfileDatabase(Context context){
        super(context);
    }

    protected UserProfileModel userProfileModel(String where, String[] args, String groupBy, String having, String order, String limit){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(UserProfile.TABEL_NAME,data,where,args,groupBy,having,order,limit);
        UserProfileModel model = new UserProfileModel();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            model.setUuid(cursor.getString(cursor.getColumnIndex(UserProfile.USER_ID)));
            model.setName(cursor.getString(cursor.getColumnIndex(UserProfile.USER_NAME)));
            model.setEmail(cursor.getString(cursor.getColumnIndex(UserProfile.USER_EMAIL)));
            model.setDate_birth(cursor.getLong(cursor.getColumnIndex(UserProfile.USER_DATE_BIRTH)));
            model.setPassword(cursor.getString(cursor.getColumnIndex(UserProfile.USER_PASSWORD)));
            model.setAddress(cursor.getString(cursor.getColumnIndex(UserProfile.USER_ADDRESS)));
            model.setPhone_number(cursor.getString(cursor.getColumnIndex(UserProfile.USER_PHONE_NUMBER)));
            model.setVerification(cursor.getString(cursor.getColumnIndex(UserProfile.USER_VERIFICATION)));
            model.setPhoto(cursor.getString(cursor.getColumnIndex(UserProfile.USER_PHOTO)));
            model.setCompany_name(cursor.getString(cursor.getColumnIndex(UserProfile.USER_COMPANY_NAME)));
            model.setCompany_address(cursor.getString(cursor.getColumnIndex(UserProfile.USER_COMPANY_ADDRESS)));
        }
        cursor.close();
        return model;
    }

    protected List<UserProfileModel> fetchall (String where, String[] args, String groupBy, String having, String order, String limit){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(UserProfile.TABEL_NAME,data,where,args,groupBy,having,order,limit);
        List<UserProfileModel> result = new ArrayList<>();
        if (cursor.getCount()>0){
            cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    String uuid = cursor.getString(cursor.getColumnIndex(UserProfile.USER_ID));
                    String name = cursor.getString(cursor.getColumnIndex(UserProfile.USER_NAME));
                    String email = cursor.getString(cursor.getColumnIndex(UserProfile.USER_EMAIL));
                    long date_birth = cursor.getLong(cursor.getColumnIndex(UserProfile.USER_DATE_BIRTH));
                    String password = cursor.getString(cursor.getColumnIndex(UserProfile.USER_PASSWORD));
                    String address = cursor.getString(cursor.getColumnIndex(UserProfile.USER_ADDRESS));
                    String phone = cursor.getString(cursor.getColumnIndex(UserProfile.USER_PHONE_NUMBER));
                    String verification = cursor.getString(cursor.getColumnIndex(UserProfile.USER_VERIFICATION));
                    String photo = cursor.getString(cursor.getColumnIndex(UserProfile.USER_PHOTO));
                    String company_name = cursor.getString(cursor.getColumnIndex(UserProfile.USER_COMPANY_NAME));
                    String company_address = cursor.getString(cursor.getColumnIndex(UserProfile.USER_COMPANY_ADDRESS));
                    UserProfileModel model = new UserProfileModel(uuid,name,email,date_birth,password,address,phone,
                                                                    verification, photo,company_name,company_address);

                    result.add(model);
                    cursor.moveToNext();
                }
        }
        cursor.close();
        return result;
    }

    public UserProfileModel getRowByUUID(String uuid) {
        String where = UserProfile.USER_ID + " = ?";
        String args[] = { uuid };
        return userProfileModel(where, args, null, null, null, null);
    }

    public boolean insert(UserProfileModel UserProfileModel){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfile.USER_NAME, UserProfileModel.getName());
        contentValues.put(UserProfile.USER_EMAIL, UserProfileModel.getEmail());
        contentValues.put(UserProfile.USER_DATE_BIRTH, UserProfileModel.getDate_birth());
        contentValues.put(UserProfile.USER_PASSWORD, UserProfileModel.getPassword());
        contentValues.put(UserProfile.USER_ADDRESS, UserProfileModel.getAddress());
        contentValues.put(UserProfile.USER_PHONE_NUMBER, UserProfileModel.getPhone_number());
        contentValues.put(UserProfile.USER_VERIFICATION, UserProfileModel.getVerification());
        contentValues.put(UserProfile.USER_PHOTO, UserProfileModel.getPhoto());
        contentValues.put(UserProfile.USER_COMPANY_NAME, UserProfileModel.getCompany_name());
        contentValues.put(UserProfile.USER_COMPANY_ADDRESS, UserProfileModel.getCompany_address());

        boolean result = (sqLiteDatabase.insert(UserProfile.TABEL_NAME,null,contentValues) > -1);
        return result;
    }
}