package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    MaterialButton buttonLogin;
    EditText editNumber;
    EditText editPassword;
    TextView forgotPassword;
    TextView createAccount;
    Util util;
    Pref pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyclone_login);
        util = new Util(getApplicationContext());
        pref = new Pref(getApplicationContext());
        initialize();

    }

    private void initialize() {

        forgotPassword = findViewById(R.id.text_forgot_pw);
        createAccount = findViewById(R.id.text_register);
        buttonLogin = findViewById(R.id.button_login);
        editNumber = findViewById(R.id.edittext_number);
        editPassword = findViewById(R.id.edittext_password);
        buttonLogin.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        createAccount.setOnClickListener(this);


    }

    public void checkEmailPassword() {
        String mobile = editNumber.getText().toString();
        String password = editPassword.getText().toString();
        if (Variable.Email.contentEquals(mobile)) {

            if (Variable.Password.contentEquals(password)) {
                pref.setEmail(mobile);
                pref.setPassword(password);
                pref.setIsLoggedIn(true);
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
                finish();
                util.makeMessage("Logged in");
            } else {
                editPassword.setError("Incorrect password");
            }
        } else {
            editNumber.setError("Incorrect Email");
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login: {
                String mobile = editNumber.getText().toString();
                String password = editPassword.getText().toString();
                if (!Validator.checkNotEmpty(mobile)) {
                    editNumber.setError("is empty");
                    return;
                }
                if (!Validator.checkNotEmpty(password)) {
                    editPassword.setError("is empty");
                    return;
                }
                if (!Validator.checkNum(mobile)) {
                    editNumber.setError("Enter email");
                    return;
                }
                if (!Validator.checkPassword(password)) {
                    editPassword.setError("Must include 1 Uppercase 1 lowercase and 1 special symbol");
                    return;
                }
                checkEmailPassword();
                break;
            }
            case R.id.text_forgot_pw: {
                util.makeMessage("forgotten");
                break;
            }
            case R.id.text_register: {
                util.makeMessage("make account");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pref.getLoggedIn()) {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
