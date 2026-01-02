package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {

    Button btnNext;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        btnNext.setOnClickListener(v -> {
            // Navigate to Second Onboarding Screen
            Intent intent = new Intent(OnboardingActivity.this, OnboardingTwoActivity.class);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> {
            finish(); // Go back to MainActivity
        });
    }
}
