package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingTwoActivity extends AppCompatActivity {

    Button btnNext;
    ImageView btnBack;
    TextView btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_two);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnSkip = findViewById(R.id.btnSkip);

        btnNext.setOnClickListener(v -> {
            // Navigate to Third Onboarding Screen
            Intent intent = new Intent(OnboardingTwoActivity.this, OnboardingThreeActivity.class);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> {
            finish(); // Go back to first onboarding screen
        });
        
        // Skip button - navigate to Login/Welcome screen
        btnSkip.setOnClickListener(v -> {
            Intent intent = new Intent(OnboardingTwoActivity.this, LoginActivity.class);
            startActivity(intent);
            finishAffinity();
        });
    }
}
