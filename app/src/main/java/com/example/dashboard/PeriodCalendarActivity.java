package com.example.dashboard;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PeriodCalendarActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_calendar);

        // UI Elements
        CalendarView calendarView = findViewById(R.id.period_calendar);


    }
}

