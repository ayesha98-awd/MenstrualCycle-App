package com.example.dashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SymptomsTrackerActivity extends AppCompatActivity {

    private Spinner symptomsSpinner, moodSpinner;
    private EditText notesInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms_tracker);

        // UI Elements
        symptomsSpinner = findViewById(R.id.symptoms_spinner);
        moodSpinner = findViewById(R.id.mood_spinner);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button saveButton = findViewById(R.id.save_symptoms);

        // Symptoms & Mood List
        String[] symptoms = {"Headache", "Cramps", "Fatigue", "Acne", "Nausea"};
        String[] moods = {"Happy", "Sad", "Anxious", "Irritated", "Relaxed"};

        // Set Spinners
        ArrayAdapter<String> symptomsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, symptoms);
        symptomsSpinner.setAdapter(symptomsAdapter);

        ArrayAdapter<String> moodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, moods);
        moodSpinner.setAdapter(moodAdapter);

        // Save Button Click Event
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String symptom = symptomsSpinner.getSelectedItem().toString();
                String mood = moodSpinner.getSelectedItem().toString();


                Toast.makeText(SymptomsTrackerActivity.this, "Saved: " + symptom + " | " + mood , Toast.LENGTH_SHORT).show();
            }
        });
    }
}

