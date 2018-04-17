package com.example.bajag.pinewood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Welcom extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout layoutdot;
    private TextView[]dotstv;
    private  int[]layouts;
    private Button btnSkip;
    private Button btnNext;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isFirstApp()){
            startMainActivity();
            finish();

        }


        setStatusBarTransparent();
        setContentView(R.layout.activity_welcom);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        layoutdot=findViewById(R.id.layoutDots);
        btnNext=findViewById(R.id.btn_next);
        btnSkip=findViewById(R.id.btn_skip);

       btnSkip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //when user click skip to main activity
               startMainActivity();
              // finish();

           }
       });

       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int currentPage=viewPager.getCurrentItem()+1;
               if(currentPage<layouts.length) {
                   //move to next
                   viewPager.setCurrentItem(currentPage);
               }else
                   {
                   startMainActivity();
               }


           }
       });
       layouts=new int[]{R.layout.slide1,R.layout.slide2};
       sliderAdapter=new SliderAdapter(layouts,getApplicationContext());
       viewPager.setAdapter(sliderAdapter);
       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
          if(position==layouts.length-1){
              btnNext.setText("START");
              btnSkip.setVisibility(View.GONE);
          }else{
              btnNext.setText("NEXT");
              btnSkip.setVisibility(View.VISIBLE);
          }
          setdotStatus(position);
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

       setdotStatus(0);

    }

    private  boolean isFirstApp(){
        SharedPreferences ref=getApplicationContext().getSharedPreferences("pinewood", Context.MODE_PRIVATE);
           return  ref.getBoolean("FirstTimeStartFlag",true);
    }

   private void setFirstTimeStartStatus(boolean stt){
       SharedPreferences ref=getApplicationContext().getSharedPreferences("pinewood", Context.MODE_PRIVATE);
       SharedPreferences.Editor editor=ref.edit();
       editor.putBoolean("FirstTimeStartFlag",stt);
       editor.commit();
   }

    private void setdotStatus(int page){
    layoutdot.removeAllViews();
    dotstv=new  TextView[layouts.length];
    for(int i=0;i<dotstv.length;i++){
       dotstv[i]=new TextView(this);
       dotstv[i].setText(Html.fromHtml("&#8226;"));
       dotstv[i].setTextSize(30);
       dotstv[i].setTextColor(Color.parseColor("#a9b4bb"));
       layoutdot.addView(dotstv[i]);
   }
   //set current active dot
        if(dotstv.length>0){
       dotstv[page].setTextColor(Color.parseColor("#ffffff"));
        }
    }

    private void startMainActivity(){
        setFirstTimeStartStatus(true);
        startActivity(new Intent(Welcom.this,MainActivity.class));


    }
    private void  setStatusBarTransparent(){
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }


    }
}
