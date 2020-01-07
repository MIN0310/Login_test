package com.min.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {


    private EditText edUserid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        edUserid = findViewById(R.id.ed_userid);


    }
    public void button(View view){
//        getIntent().putExtra("USERID", uid);
//        setResult(RESULT_OK, getIntent());
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
        String uid = edUserid.getText().toString();
        pref.edit()
                .putString("id", uid)
                .commit();
        Log.d("Account", "button: "+uid);
        AccountActivity.this.setResult(RESULT_OK);
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
        finish();
    }
}
