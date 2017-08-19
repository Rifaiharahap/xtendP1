package com.example.xyzskylake.extend.Database;

import android.content.Context;

/**
 * Created by harzen on 18/08/17.
 */

public class UserProfilDatabase extends DatabaseHelper {

    private String[] data = {UserProfil.USER_ID, UserProfil.USER_NAME, UserProfil.USER_EMAIL,
                            UserProfil.USER_DATE_BIRTH, UserProfil.USER_EMAIL, UserProfil.USER_PASSWORD,
                            UserProfil.USER_ADDRESS, UserProfil.USER_PHONE_NUMBER, UserProfil.USER_VERIFICATION,
                            UserProfil.USER_PHOTO, UserProfil.USER_COMPANY_NAME, UserProfil.USER_COMPANY_ADDRESS};

    public UserProfilDatabase(Context context){
        super(context);
    }
}