package com.min.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int RC_LOGIN = 1;
    boolean login = false;
    private EditText edUserid;
    private EditText edPassword;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUserid = findViewById(R.id.ed_userid);
        edPassword = findViewById(R.id.ed_password);
        edPhone = findViewById(R.id.ed_phone);
        if(!login){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);
        }
    }


}
