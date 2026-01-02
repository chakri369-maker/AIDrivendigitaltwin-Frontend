package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class AlertPreferencesActivity extends AppCompatActivity {

    LinearLayout optHourly, optDaily, optWeekly;
    ImageView checkHourly, checkDaily, checkWeekly;
    SwitchCompat switchPush, switchEmail;
    Button btnComplete;

    String selectedFrequency = "Daily";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_preferences);

        optHourly = findViewById(R.id.optHourly);
        optDaily = findViewById(R.id.optDaily);
        optWeekly = findViewById(R.id.optWeekly);

        checkHourly = findViewById(R.id.checkHourly);
        checkDaily = findViewById(R.id.checkDaily);
        checkWeekly = findViewById(R.id.checkWeekly);

        switchPush = findViewById(R.id.switchPush);
        switchEmail = findViewById(R.id.switchEmail);
        btnComplete = findViewById(R.id.btnComplete);

        View.OnClickListener freqClick = v -> {
            resetFrequencySelection();
            v.setBackgroundResource(R.drawable.option_selected);

            if (v == optHourly) {
                selectedFrequency = "Hourly";
                checkHourly.setVisibility(View.VISIBLE);
                checkHourly.setImageResource(R.drawable.bg_icon_selected); // Using the blue circle
            } else if (v == optDaily) {
                selectedFrequency = "Daily";
                checkDaily.setVisibility(View.VISIBLE);
                checkDaily.setImageResource(R.drawable.bg_icon_selected);
            } else if (v == optWeekly) {
                selectedFrequency = "Weekly";
                checkWeekly.setVisibility(View.VISIBLE);
                checkWeekly.setImageResource(R.drawable.bg_icon_selected);
            }
        };

        optHourly.setOnClickListener(freqClick);
        optDaily.setOnClickListener(freqClick);
        optWeekly.setOnClickListener(freqClick);

        btnComplete.setOnClickListener(v -> {
            boolean pushEnabled = switchPush.isChecked();
            boolean emailEnabled = switchEmail.isChecked();

            String message = "Setup Complete!\n" +
                    "Frequency: " + selectedFrequency + "\n" +
                    "Push: " + (pushEnabled ? "ON" : "OFF") + "\n" +
                    "Email: " + (emailEnabled ? "ON" : "OFF");

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            // Navigate to Dashboard
            Intent intent = new Intent(AlertPreferencesActivity.this, DashboardActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); 
        });
    }

    private void resetFrequencySelection() {
        optHourly.setBackgroundResource(R.drawable.option_unselected);
        optDaily.setBackgroundResource(R.drawable.option_unselected);
        optWeekly.setBackgroundResource(R.drawable.option_unselected);

        checkHourly.setVisibility(View.INVISIBLE);
        checkDaily.setVisibility(View.INVISIBLE);
        checkWeekly.setVisibility(View.INVISIBLE);
    }
}
