package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        EditText edPassword = findViewById(R.id.ed_password);
        pw = edPassword.getText().toString();

    }
    public void button(View view){
//        getIntent().putExtra("PASSWORD", pw);
//        setResult(RESULT_OK, getIntent());
        SharedPreferences pref =
                getSharedPreferences("login", MODE_PRIVATE);
        pref.edit()
                .putString("password", pw)
                .commit();
        Intent intent = new Intent(this, PhoneActivity.class);
        startActivity(intent);
        finish();
    }
}
