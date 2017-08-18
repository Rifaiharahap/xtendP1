package com.example.xyzskylake.extend.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by harzen on 18/08/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    protected static final String DATABASE_NAME = "xtend_db";
    protected static final Integer DATABASE_VERSION = 1;

    public DatabaseHelper(Context contex){
        super(contex,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS" + UserProfil.CREATE_QUERY);
        onCreate(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static final class UserProfil implements BaseColumns{
        public static final String TABEL_NAME = "user_profil";
        public static final String USER_ID = "uuid";
        public static final String USER_NAME = "name";
        public static final String USER_EMAIL = "email";
        public static final String USER_PASSWORD = "password";
        public static final String USER_ADDRESS = "address";
        public static final String USER_PHONE_NUMBER = "phone_number";
        public static final String USER_PHOTO = "photo";
        public static final String USER_COMPANY_NAME = "company_name";
        public static final String USER_COMPANY_ADDRESS = "company_address";
        public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXIST" + TABEL_NAME + "(" +
                USER_ID + "VARCHAR NOT NULL PRIMARY KET," +
                USER_NAME + "VARCHAR," +
                USER_EMAIL + "VARCHAR," +
                USER_PASSWORD + "VARCHAR," +
                USER_ADDRESS + "VARCHAR," +
                USER_PHONE_NUMBER  + "VARCHAR," +
                USER_PHOTO + "VARCHAR," +
                USER_COMPANY_NAME + "VARCHAR," +
                USER_COMPANY_ADDRESS + "VARCHAR)";


    }
}
