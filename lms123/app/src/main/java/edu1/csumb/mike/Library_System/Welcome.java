package edu1.csumb.mike.Library_System;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        View ClickHere = findViewById(R.id.clickhere);
        ClickHere.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v.getId() == R.id.clickhere) {
            Intent I = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(I);
        }
    }
}
