package com.example.palak.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener{
    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);
        tvregister=(TextView) findViewById(R.id.tvregister);
        bLogin=(Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        tvregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bLogin:

                break;
            case R.id.tvregister:

                startActivity(new Intent(this,register.class));
                break;

        }

    }
}
