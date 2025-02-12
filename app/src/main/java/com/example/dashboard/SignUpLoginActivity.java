package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dashboard.HomeDashboardActivity;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);

        // Initialize UI Elements
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        Button loginButton = findViewById(R.id.login_button);
        Button signupButton = findViewById(R.id.signup_button);

        // Login Button Click Event
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpLoginActivity.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpLoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    // Navigate to Home Dashboard Screen after login
                    Intent intent = new Intent(SignUpLoginActivity.this, HomeDashboardActivity.class);
                    startActivity(intent);
                    finish(); // Close this activity
                }
            }
        });

        // Sign Up Button Click Event
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Sign Up Screen
                Intent intent = new Intent(SignUpLoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
