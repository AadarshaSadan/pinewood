package com.example.bajag.pinewood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this, Welcom.class);
        startActivity(intent);
        setContentView(R.layout.activity_main);
        //here goes code


    }
}
