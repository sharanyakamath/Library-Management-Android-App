package com.example.palak.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bLogout;
    EditText etName, etUsername,etEmail_id,etFine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername=(EditText) findViewById(R.id.etUsername);
        etName=(EditText) findViewById(R.id.etName);
        etEmail_id=(EditText) findViewById(R.id.etEmail_id);
        etFine=(EditText) findViewById(R.id.etFine);
        bLogout=(Button) findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bLogout:
                startActivity(new Intent(this, login.class));
                break;

        }

    }
}
