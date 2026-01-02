package com.simats.ai_drivendigitaltwin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacySecurityActivity extends AppCompatActivity {

    ImageView btnBack;
    ProgressBar progressSecurity;
    Switch switch2FA, switchBiometric, switchDataSharing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_security);

        btnBack = findViewById(R.id.btnBack);
        progressSecurity = findViewById(R.id.progressSecurity);
        switch2FA = findViewById(R.id.switch2FA);
        switchBiometric = findViewById(R.id.switchBiometric);
        switchDataSharing = findViewById(R.id.switchDataSharing);

        // Load preferences
        SharedPreferences prefs = getSharedPreferences("SecurityPrefs", MODE_PRIVATE);
        switch2FA.setChecked(prefs.getBoolean("twoFactorAuth", true));
        switchBiometric.setChecked(prefs.getBoolean("biometricLogin", false));
        switchDataSharing.setChecked(prefs.getBoolean("dataSharing", false));

        // Set security progress
        progressSecurity.setProgress(85);

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Two-Factor Authentication toggle
        switch2FA.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("twoFactorAuth", isChecked);
            editor.apply();
            Toast.makeText(this, isChecked ? "Two-Factor Authentication enabled" : "Two-Factor Authentication disabled", Toast.LENGTH_SHORT).show();
        });

        // Biometric Login toggle
        switchBiometric.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("biometricLogin", isChecked);
            editor.apply();
            Toast.makeText(this, isChecked ? "Biometric Login enabled" : "Biometric Login disabled", Toast.LENGTH_SHORT).show();
        });

        // Data Sharing toggle
        switchDataSharing.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("dataSharing", isChecked);
            editor.apply();
            Toast.makeText(this, isChecked ? "Data Sharing enabled" : "Data Sharing disabled", Toast.LENGTH_SHORT).show();
        });
    }
}
