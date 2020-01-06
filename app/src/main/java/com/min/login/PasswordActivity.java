package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {


    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        edPassword = findViewById(R.id.ed_password);


    }
    public void button(View view){
//        getIntent().putExtra("PASSWORD", pw);
//        setResult(RESULT_OK, getIntent());
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String pw = edPassword.getText().toString();
        editor.putString("password", pw).commit();
        Log.d("Password", "button: "+pw);
        Intent intent = new Intent(this, PhoneActivity.class);
        startActivity(intent);
        finish();
    }
}
