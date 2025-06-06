package com.example.project1;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageView;

public class Pref {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    final int mode = 0;
    private static final String PREF_NAME = "Project1";
    private static final String KEY_LOGIN = "loggedIn";
    private static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD="password";

    public Pref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, mode);
        editor = sharedPreferences.edit();
    }

    public void clearSharedPreference() {
        editor.clear();
        editor.commit();
    }

    public void setIsLoggedIn(Boolean value) {
        editor.putBoolean(KEY_LOGIN, value);
        editor.commit();
    }

    public void setEmail(String value) {
        editor.putString(KEY_EMAIL, value);
        editor.commit();
    }
    public void setPassword(String value){
        editor.putString(KEY_PASSWORD,value);
        editor.commit();
    }

    public boolean getLoggedIn() {
        return sharedPreferences.getBoolean(KEY_LOGIN, false);

    }

    public String getEmail() {
        return sharedPreferences.getString(KEY_EMAIL, "dipeshmhrzn28@gmail.com");
    }
    public String getPassword(){
        return sharedPreferences.getString(KEY_PASSWORD,"dipesh@123A");
    }
}
