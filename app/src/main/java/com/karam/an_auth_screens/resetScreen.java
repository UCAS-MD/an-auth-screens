package com.karam.an_auth_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class resetScreen extends AppCompatActivity {

    EditText mEmailEditText;
    EditText mNewPasswordEditText;
    Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_screen);

        String intentEmail = getIntent().getStringExtra("email");

        mEmailEditText = findViewById(R.id.emailEditText);
        mNewPasswordEditText = findViewById(R.id.resetPasswordEditText);
        mSaveButton = findViewById(R.id.saveButton);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString().trim();
                String newPassword = mNewPasswordEditText.getText().toString().trim();

                if (email.equalsIgnoreCase(intentEmail)){
                    Toast.makeText(resetScreen.this, "Password reset successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(resetScreen.this, loginScreen.class);
                    intent.putExtra("email", intentEmail);
                    intent.putExtra("password", newPassword);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(resetScreen.this, "Check your email!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}