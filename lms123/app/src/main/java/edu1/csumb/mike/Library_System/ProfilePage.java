package edu1.csumb.mike.Library_System;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener{


    MySQLiteHelper db = new MySQLiteHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }
}
