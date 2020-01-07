package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {


    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        edPhone = findViewById(R.id.ed_phone);

    }
    public void button(View view){
//        getIntent().putExtra("PHONE", ph);
//        setResult(RESULT_OK, getIntent());
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
        String ph = edPhone.getText().toString();
        pref.edit()
                .putString("phone", ph)
                .commit();
        Log.d("Phone", "button: "+ph);
        finish();
    }
}
