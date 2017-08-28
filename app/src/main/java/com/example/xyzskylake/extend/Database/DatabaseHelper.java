package com.example.xyzskylake.extend.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

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

        db.execSQL(UserProfile.CREATE_QUERY);
        Log.i("Create Query", UserProfile.CREATE_QUERY);
        db.execSQL(Ticket.CREATE_QUERY);
        db.execSQL(Action.CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + UserProfile.CREATE_QUERY);
        db.execSQL("DROP TABLE IF EXISTS" + Ticket.CREATE_QUERY);
        db.execSQL("DROP TABLE IF EXISTS" + Action.CREATE_QUERY);
        onCreate(db);

    }

    public static final class UserProfile implements BaseColumns{
        public static final String TABEL_NAME = "user_profil";
        public static final String USER_ID = "uuid";
        public static final String USER_NAME = "name";
        public static final String USER_EMAIL = "email";
        public static final String USER_DATE_BIRTH = "date_birth";
        public static final String USER_PASSWORD = "password";
        public static final String USER_ADDRESS = "address";
        public static final String USER_PHONE_NUMBER = "phone_number";
        public static final String USER_VERIFICATION = "verification";
        public static final String USER_PHOTO = "photo";
        public static final String USER_COMPANY_NAME = "company_name";
        public static final String USER_COMPANY_ADDRESS = "company_address";
        public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " + TABEL_NAME + " (" +
                USER_ID + " VARCHAR NOT NULL PRIMARY KEY, " +
                USER_NAME + " VARCHAR, " +
                USER_EMAIL + " VARCHAR, " +
                USER_DATE_BIRTH + " LONG, " +
                USER_PASSWORD + " VARCHAR, " +
                USER_ADDRESS + " VARCHAR, " +
                USER_PHONE_NUMBER  + " VARCHAR, " +
                USER_PHOTO + " VARCHAR, " +
                USER_VERIFICATION + " VARCHAR, " +
                USER_COMPANY_NAME + " VARCHAR, " +
                USER_COMPANY_ADDRESS + " VARCHAR)";
    }

    public static final class Ticket implements BaseColumns{
        public static final String TABLE_NAME = "ticket";
        public static final String TABLE_ID = "id";
        public static final String TABLE_SUBJECT = "subject";
        public static final String TABLE_DESCRIPTION = "description";
        public static final String TABLE_LAT = "lat";
        public static final String TABLE_LNG = "lng";
        public static final String TABLE_RADIUS = "radius";
        public static final String TABLE_CREATE_DATE = "create_date";
        public static final String TABLE_CREATE_BY = "create_by";
        public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
                TABLE_ID + " VARCHAR NOT NULL PRIMARY KEY, " +
                TABLE_SUBJECT + " VARCHAR, " +
                TABLE_DESCRIPTION + " VARCHAR, " +
                TABLE_LAT + " DOUBLE, " +
                TABLE_LNG + " DOUBLE, " +
                TABLE_RADIUS + " DOUBLE, " +
                TABLE_CREATE_DATE + " LONG, " +
                TABLE_CREATE_BY  + " VARCHAR)";
    }

    public static final class Action implements BaseColumns{
        public static final String TABEL_ACTION = "action";
        public static final String ACTION_ID = "id";
        public static final String ACTION_TICKET_ID = "ticket_id";
        public static final String ACTION_NAME = "name";
        public static final String ACTION_COMMENT = "comment";
        public static final String ACTION_PHOTO = "photo";
        public static final String ACTION_DATE = "date";
        public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " + TABEL_ACTION + " (" +
                ACTION_ID + " VARCHAR NOT NULL PRIMARY KEY, " +
                ACTION_TICKET_ID + " VARCHAR, " +
                ACTION_NAME + " VARCHAR, " +
                ACTION_COMMENT + " VARCHAR, " +
                ACTION_PHOTO + " VARCHAR, " +
                ACTION_DATE + " LONG)";

    }
}
