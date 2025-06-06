package com.example.project1;

import android.content.Context;
import android.widget.Toast;

public class Util {
    Context context;

    Util(Context context){
        this.context = context;
    }

    public void makeMessage(String text){
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
