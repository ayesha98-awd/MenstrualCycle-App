package com.example.dashboard;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch themeSwitch;
    private EditText nameInput, emailInput;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // UI Elements
        themeSwitch = findViewById(R.id.notifications_switch);
        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);


        // SharedPreferences initialize
        sharedPreferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        // Load saved settings if available
        loadPreferences();


    }

    private void loadPreferences() {
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");
        boolean isDarkTheme = sharedPreferences.getBoolean("theme", false);

        nameInput.setText(name);
        emailInput.setText(email);
        themeSwitch.setChecked(isDarkTheme);
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        boolean isDarkTheme = themeSwitch.isChecked();

        editor.putString("name", name);
        editor.putString("email", email);
        editor.putBoolean("theme", isDarkTheme);
        editor.apply();

        Toast.makeText(SettingsActivity.this, "Preferences Saved!", Toast.LENGTH_SHORT).show();
    }
}
