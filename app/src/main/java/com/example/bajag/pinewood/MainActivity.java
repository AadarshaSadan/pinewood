package com.example.bajag.pinewood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Intent intent = new Intent(MainActivity.this, Welcom.class);
        //startActivity(intent);

        //here goes code
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {
            //show sign up activity
            startActivity(new Intent(MainActivity.this, Welcom.class));
            Toast.makeText(MainActivity.this, "welcome to pinewood cafe", Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_main);
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();
        ///
        Spinner mySpinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>myAdapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);





    }
}
