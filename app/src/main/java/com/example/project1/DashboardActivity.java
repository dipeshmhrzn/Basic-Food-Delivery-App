package com.example.project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.zip.Inflater;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgMenu;
    Pref pref;
    Util util;
    SearchView searchView;
    ImageView imgLogOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyclone_dashboard);
        pref=new Pref(getApplicationContext());
        util=new Util(getApplicationContext());
        initialize();

    }

    private void initialize(){
        imgLogOut=findViewById(R.id.img_logOut);
        imgMenu = findViewById(R.id.img_menu);
        searchView= findViewById(R.id.view_search);
        searchView.clearFocus();
        searchView.onActionViewCollapsed();
        imgMenu.setOnClickListener(this);
        imgLogOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_menu:{
                Intent intent = new Intent(getApplicationContext(),CategoryActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.img_logOut:{
                showLogOutAlert();
                break;
            }
        }
    }
    public void showLogOutAlert(){
        LayoutInflater layoutInflater=LayoutInflater.from(DashboardActivity.this);
        final View dialogLogOut = layoutInflater.inflate(R.layout.dialog_logout,null);
        AlertDialog alertDialog = new AlertDialog.Builder(DashboardActivity.this).create();
        alertDialog.setView(dialogLogOut);
        Button logOut = dialogLogOut.findViewById(R.id.button_logOut);
        Button cancel = dialogLogOut.findViewById(R.id.button_cancel);
        Button showEmail = dialogLogOut.findViewById(R.id.button_show_email);
        Button showPassword = dialogLogOut.findViewById(R.id.button_show_password);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                pref.clearSharedPreference();
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        showEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                util.makeMessage(pref.getEmail());
            }
        });
        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                util.makeMessage(pref.getPassword());
            }
        });
        alertDialog.show();
    }
}

