package com.zurefaseverler.kithub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements  View.OnClickListener {

    private EditText info_name, info_sur_name, info_e_mail, info_password_attempt, info_password_repeat, info_phone_num;

    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+(\\.[a-z]+)+";
    private String phonePattern = "5[0-9]+";

    private boolean err_mail = false, err_phone = false, err_pass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageButton go_back = findViewById(R.id.go_back);
        go_back.setOnClickListener((View.OnClickListener) this);

        Button sign_up_confirm = findViewById(R.id.sign_up_confirm);
        sign_up_confirm.setOnClickListener((View.OnClickListener) this);



        info_name = findViewById(R.id.name);
        info_sur_name = findViewById(R.id.sur_name);
        info_e_mail = findViewById(R.id.e_mail);
        info_password_attempt = findViewById(R.id.password_attempt);
        info_password_repeat = findViewById(R.id.password_repeat);
        info_phone_num = findViewById(R.id.phone_num);

        info_phone_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!info_phone_num.getText().toString().matches(phonePattern) || info_phone_num.getText().toString().length() != 10){
                    info_phone_num.setError(getString(R.string.profile_info_wrong_phone));
                    err_phone = true;
                }
                else{
                    err_phone = false;
                }

            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        info_e_mail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!info_e_mail.getText().toString().matches(emailPattern)){
                    info_e_mail.setError(getString(R.string.profile_info_wrong_mail));
                    err_mail = true;
                }
                else{
                    err_mail = false;
                }

            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        info_password_attempt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int strength = checkPassStrength(info_password_attempt.getText().toString());
                if(info_password_attempt.getText().toString().length() > 20)  info_password_attempt.setError("Parola 20 karakterden uzun olamaz.");
                if(strength == -1)  info_password_attempt.setTextColor(Color.RED);
                else if(strength == 0)  info_password_attempt.setTextColor(Color.parseColor("#ffa41b"));
                else if(strength == 1)  info_password_attempt.setTextColor(Color.GREEN);
            }

            private int checkPassStrength(String pass) {
                String medium = "^(?=.*[0-9]).{6,20}$";
                String strong = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
                if(pass.matches(strong))    return 1;
                else if(pass.matches(medium))   return 0;
                else     return -1;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        info_password_repeat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!info_password_repeat.getText().toString().equals(info_password_attempt.getText().toString())){
                    info_password_repeat.setError(getString(R.string.mismatched_password));
                    err_pass = true;
                }
                else{
                    err_pass = false;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.sign_up_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info_name.getText().toString().length() < 1){
                    Toast.makeText(getApplicationContext(),"Isim bilgisi eksik",Toast.LENGTH_SHORT).show();
                }
                else if(info_sur_name.getText().toString().length() < 1 || err_mail){
                    Toast.makeText(getApplicationContext(),"Soy isim bilgisi eksik",Toast.LENGTH_SHORT).show();
                }
                else if(info_e_mail.getText().toString().length() < 1){
                    Toast.makeText(getApplicationContext(),"E mail bilgisi eksik",Toast.LENGTH_SHORT).show();
                }
                else if(info_password_attempt.getText().toString().length() < 1){
                    Toast.makeText(getApplicationContext(),"Sifre bilgisi eksik",Toast.LENGTH_SHORT).show();
                }
                else if(info_password_repeat.getText().toString().length() < 1 || err_pass){
                    Toast.makeText(getApplicationContext(),"Sifre tekrar bilgisi eksik",Toast.LENGTH_SHORT).show();
                }
                else if(info_phone_num.getText().toString().length() < 1 || err_phone){
                    Toast.makeText(getApplicationContext(),"Numara bilgisi eksik",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Kayit basarili...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
                    startActivity(intent);
                }
            }
        });





    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_back:
                onBackPressed();
                break;



        }
    }
}