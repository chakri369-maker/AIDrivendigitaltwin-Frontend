package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    ImageView btnBack;
    Switch switchNotifications;
    LinearLayout btnPrivacy, btnHelp, btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnBack = findViewById(R.id.btnBack);
        switchNotifications = findViewById(R.id.switchNotifications);
        btnPrivacy = findViewById(R.id.btnPrivacy);
        btnHelp = findViewById(R.id.btnHelp);
        btnSignOut = findViewById(R.id.btnSignOut);

        // Load notification preference
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        boolean notificationsEnabled = prefs.getBoolean("pushNotifications", true);
        switchNotifications.setChecked(notificationsEnabled);

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Toggle notifications
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("pushNotifications", isChecked);
            editor.apply();
            Toast.makeText(this, isChecked ? "Notifications enabled" : "Notifications disabled", Toast.LENGTH_SHORT).show();
        });

        // Privacy & Security
        btnPrivacy.setOnClickListener(v -> {
            startActivity(new Intent(this, PrivacySecurityActivity.class));
        });

        // Help & Support
        btnHelp.setOnClickListener(v -> {
            startActivity(new Intent(this, HelpSupportActivity.class));
        });

        // Sign Out
        btnSignOut.setOnClickListener(v -> {
            // Clear user data
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            Toast.makeText(this, "Signed out successfully", Toast.LENGTH_SHORT).show();

            // Navigate to Login screen
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
