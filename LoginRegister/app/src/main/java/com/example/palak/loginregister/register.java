package com.example.palak.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity implements View.OnClickListener{
    Button bRegister;
    EditText etName, etUsername, etPassword,etEmail_id,etEnter_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName=(EditText) findViewById(R.id.etName);
        etEmail_id=(EditText) findViewById(R.id.etEmail_id);
        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);
        bRegister=(Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bRegister:

                break;

        }

    }
}
