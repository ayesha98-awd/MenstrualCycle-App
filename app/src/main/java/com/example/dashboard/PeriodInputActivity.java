package com.example.dashboard;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PeriodInputActivity extends AppCompatActivity {

    private EditText etStartDate, etCycleLength;
    private TextView tvNextPeriod;
    private com.example.periodtracker.PeriodTracker periodTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_input);

        etStartDate = findViewById(R.id.setStartDate); // Corrected ID reference
        etCycleLength = findViewById(R.id.etCycleLength);
        tvNextPeriod = findViewById(R.id.tvNextPeriod);
        Button btnSave = findViewById(R.id.btnSave);

        periodTracker = new com.example.periodtracker.PeriodTracker(this);

        // Display previously saved next period date
        String savedNextPeriod = periodTracker.getNextPeriodDate();
        if (!savedNextPeriod.isEmpty()) {
            tvNextPeriod.setText(String.format("Next Period: %s", savedNextPeriod));
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = etStartDate.getText().toString().trim();
                String cycleLengthStr = etCycleLength.getText().toString().trim();
                int cycleLength = 28; // Default cycle length

                if (!cycleLengthStr.isEmpty()) {
                    try {
                        cycleLength = Integer.parseInt(cycleLengthStr);
                        if (cycleLength <= 0) {
                            Toast.makeText(PeriodInputActivity.this, "Cycle length must be a positive number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(PeriodInputActivity.this, "Invalid cycle length. Enter a number.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if (!isValidDate(startDate)) {
                    Toast.makeText(PeriodInputActivity.this, "Invalid date format. Use YYYY-MM-DD", Toast.LENGTH_SHORT).show();
                    return;
                }

                periodTracker.savePeriodData(startDate, cycleLength);

                // Show next period date
                tvNextPeriod.setText(String.format("Next Period: %s", periodTracker.getNextPeriodDate()));
                Toast.makeText(PeriodInputActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to validate date format
    private boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
