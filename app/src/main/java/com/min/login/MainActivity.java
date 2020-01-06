package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eduserid;
    private EditText edpassword;
    private EditText edphone;
    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eduserid = findViewById(R.id.ed_userid);
        edpassword = findViewById(R.id.ed_password);
        edphone = findViewById(R.id.ed_phone);
        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.switch1);
                text.setText(isNext? "登入": "註冊");
                TextView text2 = findViewById(R.id.button);
                text2.setText(isNext? "登入": "註冊");
            }
        });

    }
    public void button(View view){
        if(!isNext){
            Intent intent = new Intent(this, AccountActivity.class);
            startActivity(intent);
        }else {
            EditText edUserid = findViewById(R.id.ed_userid);
            EditText edPassword = findViewById(R.id.ed_password);
            EditText edPhone = findViewById(R.id.ed_phone);
        }
    }
}
