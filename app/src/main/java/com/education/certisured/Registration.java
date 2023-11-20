package com.education.certisured;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextEmail, editTextPassword, editTextPhoneNumber, editTextAge;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        intializeId();
    }

    private void intializeId(){
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextAge = findViewById(R.id.editTextAge);
        registrationButton=(Button) findViewById(R.id.buttonRegister);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonRegister) {
            saveRegistrationDetails();
        }
    }

    private void saveRegistrationDetails() {
        String username = editTextUsername.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String age = editTextAge.getText().toString();
        // Save data to SharedPreferences
        SharedPreferences preferences = getSharedPreferences("user_details", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putString("phoneNumber", phoneNumber);
        editor.putString("age", age);
        editor.apply();
        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
    }
}