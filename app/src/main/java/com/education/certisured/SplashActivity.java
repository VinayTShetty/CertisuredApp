package com.education.certisured;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigateToMainScreen();
    }

    private void navigateToMainScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(SplashActivity.this, MainScreen.class);
                startActivity(intent);
                // Close the splash activity
                finish();
            }
        }, SPLASH_DURATION);
    }

    private void checkUserLoginOrNot(){

    }
}