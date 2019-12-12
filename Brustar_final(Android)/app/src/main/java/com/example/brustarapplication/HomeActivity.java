package com.example.brustarapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    //Setting Button 클릭
    public void SettingClick(View view) {
        //SettingActivity 이동
        startActivity(new Intent(HomeActivity.this,SettingActivity.class));
    }

    //cctv Button 클릭
    public void cctvClick(View view) {
        //CCTVActivity 이동
        startActivity(new Intent(HomeActivity.this,CCTVActivity.class));
    }
}
