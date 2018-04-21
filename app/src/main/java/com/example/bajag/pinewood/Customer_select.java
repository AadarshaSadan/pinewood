package com.example.bajag.pinewood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Customer_select extends AppCompatActivity {
    private static final String TAG = "Customer_select";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_select);
        Intent i=getIntent();
        String easyPuzzle = i.getStringExtra("valueofdrop");
        ((TextView)findViewById(R.id.textTableno)).setText(easyPuzzle.toString());//display table value in textview from mainacyivity dropdown



    }
}
