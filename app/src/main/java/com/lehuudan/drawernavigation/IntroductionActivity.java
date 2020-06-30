package com.lehuudan.drawernavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroductionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

    }
    public void Trangchu(View view) {
        Intent i = new Intent(getBaseContext(),  MainActivity.class);startActivity(i);
    }
}
