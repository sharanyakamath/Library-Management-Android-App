package com.example.palak.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvregister);
        final TextView tvLoginLink = (TextView) findViewById(R.id.tvlogin);
        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(welcome.this, RegisterActivity.class);
                welcome.this.startActivity(registerIntent);
            }
        });
        tvLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(welcome.this, LoginActivity.class);
                welcome.this.startActivity(loginIntent);
            }
        });
    }
}
