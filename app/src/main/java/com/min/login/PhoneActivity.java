package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    private String ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        EditText edPhone = findViewById(R.id.ed_phone);
        ph = edPhone.getText().toString();
    }
    public void button(View view){
//        getIntent().putExtra("PHONE", ph);
//        setResult(RESULT_OK, getIntent());
        SharedPreferences pref =
                getSharedPreferences("login", MODE_PRIVATE);
        pref.edit()
                .putString("phone", ph)
                .commit();
        finish();
    }
}
