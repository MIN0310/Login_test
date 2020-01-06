package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {

    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        EditText edUserid = findViewById(R.id.ed_userid);
        uid = edUserid.getText().toString();

    }
    public void button(View view){
//        getIntent().putExtra("USERID", uid);
//        setResult(RESULT_OK, getIntent());
        SharedPreferences pref =
                getSharedPreferences("login", MODE_PRIVATE);
        pref.edit()
                .putString("id", uid)
                .commit();
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
        finish();
    }
}
