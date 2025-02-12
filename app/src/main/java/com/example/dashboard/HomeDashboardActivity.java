package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeDashboardActivity extends AppCompatActivity {

    private TextView cycleStatus, healthTips, menstrualInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);

        // Initialize UI Elements
        Button whatIsMenstrualCycleBtn = findViewById(R.id.what_is_menstrual_cycle_btn);
        Button periodCalendarBtn = findViewById(R.id.period_calendar_btn);
        Button symptomsMoodTrackerBtn = findViewById(R.id.symptoms_mood_tracker_btn);
        Button remindersNotificationsBtn = findViewById(R.id.reminders_notifications_btn);
        Button insightsReportsBtn = findViewById(R.id.insights_reports_btn);

        // Set Click Listeners
        whatIsMenstrualCycleBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeDashboardActivity.this, com.example.dashboard.PeriodInputActivity.class);
            startActivity(intent);
        });

        periodCalendarBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeDashboardActivity.this, PeriodCalendarActivity.class);
            startActivity(intent);
        });

        symptomsMoodTrackerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeDashboardActivity.this, SymptomsTrackerActivity.class);
            startActivity(intent);
        });

        remindersNotificationsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeDashboardActivity.this, RemindersActivity.class);
            startActivity(intent);
        });

        insightsReportsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeDashboardActivity.this, com.example.dashboard.PeriodInputActivity.class);
            startActivity(intent);
        });
    }
}
