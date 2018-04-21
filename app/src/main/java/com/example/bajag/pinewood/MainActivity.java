package com.example.bajag.pinewood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
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
         //
        mySpinner.setAdapter(myAdapter);





    }

    public void sendMessage(View view) {
        // Do something in response to button click
        //String[] tab_names = getResources().getStringArray(R.array.names);
        //String tabname1=tab_names[0];//"My Tab 1"
       // System.out.println("hello");
        //Log.v(TAG, "Value=" + tab_names);
        Spinner valuefromdropdown=(Spinner)findViewById(R.id.spinner);
        String Textdropdown=valuefromdropdown.getSelectedItem().toString();
        //Log.v(TAG, "Adb=" +Text);

        Intent inti= new Intent(MainActivity.this, Customer_select.class);
        inti.putExtra("valueofdrop",Textdropdown);
        startActivity(inti);
    }
}
