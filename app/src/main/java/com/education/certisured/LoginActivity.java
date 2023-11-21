package com.education.certisured;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView singIn;
    CheckBox checkBox_loginsave;
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intializeId();
        setOnClicklistner();
        setCheckBoxOncheckChagenListner();
    }
    private void intializeId(){
        singIn=(TextView)findViewById(R.id.signin_tv);
        checkBox_loginsave=(CheckBox)findViewById(R.id.checkbox_rembme);
        loginbtn=(Button)findViewById(R.id.login_bt);
    }

    private void setOnClicklistner(){
        singIn.setOnClickListener(this);
        loginbtn.setOnClickListener(this);
    }

    private void setCheckBoxOncheckChagenListner(){
        checkBox_loginsave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences preferences = getSharedPreferences("user_details", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("RM", true);
                editor.commit();
            }
        });
    }


    private String getSavedEmail() {
        SharedPreferences preferences = getSharedPreferences("user_details", MODE_PRIVATE);
        return preferences.getString("email", "");
    }

    private String getSavedPassword() {
        SharedPreferences preferences = getSharedPreferences("user_details", MODE_PRIVATE);
        return preferences.getString("password", "");
    }

    @Override
    public void onClick(View view) {
      if(view.getId()==R.id.signin_tv){
          Intent intent=new Intent(this,Registration.class);
          startActivity(intent);
      } else if (view.getId()==R.id.login_bt) {
          String savedEmail = getSavedEmail();
          String savedPassword = getSavedPassword();

          // Check if the saved email and password match the expected values
          if ("abc".equals(savedEmail) && "123456789".equals(savedPassword)) {
              // Successful login, navigate to the main screen
              Intent intent = new Intent(this, MainScreen.class);
              startActivity(intent);
              finish(); // finish the LoginActivity so the user can't go back using the back button
          } else {
              // Invalid credentials, you can show a message or handle it accordingly
              // For simplicity, let's just show a toast message
              Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
          }
      }
    }
}