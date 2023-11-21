package com.education.certisured;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
                if(checkuserRegsitrationIsDone() ){
                    if(checkuserLoginSucessfull()){
                        Intent intent = new Intent(SplashActivity.this, MainScreen.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else {
                    Intent intent = new Intent(SplashActivity.this, Registration.class);
                    startActivity(intent);
                    finish();
                }
                // Close the splash activity

            }
        }, SPLASH_DURATION);
    }

    private boolean checkuserLoginSucessfull() {
        SharedPreferences preferences = getSharedPreferences("user_details", MODE_PRIVATE);

        // Check if "Remember Me" is checked
        boolean rememberMe = preferences.getBoolean("RM", false);

        if (rememberMe) {
            // Retrieve saved username and password
            String savedemail = preferences.getString("email", "");
            String savedPassword = preferences.getString("password", "");

            // Check if saved credentials match the expected values
            return savedemail.equals("aa") && savedPassword.equals("123");
        }else {

            return false;
        }
    }



    private boolean checkuserRegsitrationIsDone(){
        SharedPreferences preferences = getSharedPreferences("user_details", MODE_PRIVATE);
        return preferences.contains("username") && preferences.contains("email")
                && preferences.contains("password") && preferences.contains("phoneNumber")
                && preferences.contains("age");
    }


}