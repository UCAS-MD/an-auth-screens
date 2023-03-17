package com.karam.an_auth_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mUsernameEditText;
    EditText mEmailEditText;
    EditText mPasswordEditText;
    EditText mMobileNumberEditText;
    Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameEditText = findViewById(R.id.usernameEditText);
        mEmailEditText = findViewById(R.id.emailEditText);
        mPasswordEditText = findViewById(R.id.passwordEditText);
        mMobileNumberEditText = findViewById(R.id.mobileNumberEditText);
        mSignUpButton = findViewById(R.id.signupButton);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameEditText.getText().toString().trim();
                String email = mEmailEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();
                String mobileNumber = mMobileNumberEditText.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, loginScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}