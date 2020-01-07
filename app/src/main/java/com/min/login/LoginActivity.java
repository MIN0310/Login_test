package com.min.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

public class LoginActivity extends AppCompatActivity {
    public static final int RC_LOGIN = 1;
    private EditText edUserid;
    private EditText edPassword;
    private EditText edPhone;
    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = findViewById(R.id.ed_userid);
        edPassword = findViewById(R.id.ed_password);
        edPhone = findViewById(R.id.ed_phone);
        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.switch1);
                text.setText(isNext? "註冊": "登入");
                TextView text2 = findViewById(R.id.button);
                text2.setText(isNext? "註冊": "登入");
            }
        });
        EditText edUserid = findViewById(R.id.ed_userid);
        SharedPreferences setting =
                getSharedPreferences("login", MODE_PRIVATE);
        edUserid.setText(setting.getString("PREF_USERID", ""));

    }
    public void button(View view){
        if(!isNext){
            EditText edUserid = findViewById(R.id.ed_userid);
            EditText edPassword = findViewById(R.id.ed_password);
            EditText edPhone = findViewById(R.id.ed_phone);
            String uid = edUserid.getText().toString();
            String pw = edPassword.getText().toString();
            String ph = edPhone.getText().toString();
            if("Jasmine".equals(uid) && "1234".equals(pw) && "0912345678".equals(ph)){
                SharedPreferences setting =
                        getSharedPreferences("login", MODE_PRIVATE);
                setting.edit()
                        .putString("PREF_USERID", uid)
                        .apply();
                finish();
            }
        }else {
            Intent intent = new Intent(this, AccountActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode == RESULT_OK){
//                String uid = data.getStringExtra("LOGIN_USERID");
//                String pw = data.getStringExtra("LOGIN_PASSWORD");
//                String ph = data.getStringExtra("LOGIN_PHONE");
//                Log.d("RESULT: ", uid + "/" + pw + "/" + ph);
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                String a = pref.getString("id","");
                String b = pref.getString("password","");
                String c = pref.getString("phone","");
                Log.d("Login", "onActivityResult: " + a + "," + b + "," + c);
                edUserid.setText(a + "");
                edPassword.setText(b + "");
                edPhone.setText(c + "");

                new AlertDialog.Builder(this)
                        .setTitle("會員資料")
                        .setMessage("帳號：" + a + "\n" + "密碼：" + b + "\n" + "電話：" + c)
                        .setPositiveButton("OK", null)
                        .show();

            }else {
//                finish(); 會關掉
            }
        }
    }
}
