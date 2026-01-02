package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingThreeActivity extends AppCompatActivity {

    Button btnNext;
    ImageView btnBack;
    TextView btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_three);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnSkip = findViewById(R.id.btnSkip);

        btnNext.setOnClickListener(v -> {
            // Navigate to Login Page
            Intent intent = new Intent(OnboardingThreeActivity.this, LoginActivity.class);
            startActivity(intent);
            finishAffinity(); // Optional: clears the onboarding stack
        });

        btnBack.setOnClickListener(v -> {
            finish(); // Go back to the second onboarding screen
        });
        
        // Skip button - navigate to Login/Welcome screen
        btnSkip.setOnClickListener(v -> {
            Intent intent = new Intent(OnboardingThreeActivity.this, LoginActivity.class);
            startActivity(intent);
            finishAffinity();
        });
    }
}
