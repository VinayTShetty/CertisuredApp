package com.education.certisured;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView singIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intializeId();
    }
    private void intializeId(){
        singIn=(TextView)findViewById(R.id.signin_tv);
        singIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      if(view.getId()==R.id.signin_tv){
          Intent intent=new Intent(this,Registration.class);
          startActivity(intent);
      }
    }
}