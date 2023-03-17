package com.karam.an_auth_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginScreen extends AppCompatActivity {

    EditText mEmailEditText;
    EditText mPasswordEditText;
    Button mLoginButton;
    TextView mResetPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        String intentEmail = getIntent().getStringExtra("email");
        String intentPassword = getIntent().getStringExtra("password");


        mEmailEditText = findViewById(R.id.emailEditText);
        mPasswordEditText = findViewById(R.id.passwordEditText);
        mLoginButton = findViewById(R.id.loginButton);
        mResetPasswordTextView = findViewById(R.id.resetPasswordTextView);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();

                if (email.equalsIgnoreCase(intentEmail) && password.equals(intentPassword)) {
                    Toast.makeText(loginScreen.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(loginScreen.this, "Check your email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mResetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the reset password activity
                Intent intent = new Intent(loginScreen.this, resetScreen.class);
                intent.putExtra("email", intentEmail);
                startActivity(intent);
                finish();
            }
        });
    }
}