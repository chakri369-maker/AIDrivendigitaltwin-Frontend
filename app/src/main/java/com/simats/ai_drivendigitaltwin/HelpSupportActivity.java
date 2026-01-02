package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HelpSupportActivity extends AppCompatActivity {

    ImageView btnBack;
    EditText searchHelp;
    LinearLayout btnLiveChat, btnEmailSupport, btnUserGuide, btnVideoTutorials;
    LinearLayout btnGettingStarted, btnAccountSettings;
    LinearLayout faq1, faq2, faq3;
    TextView btnStartLiveChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_support);

        // Initialize views
        btnBack = findViewById(R.id.btnBack);
        searchHelp = findViewById(R.id.searchHelp);
        btnLiveChat = findViewById(R.id.btnLiveChat);
        btnEmailSupport = findViewById(R.id.btnEmailSupport);
        btnUserGuide = findViewById(R.id.btnUserGuide);
        btnVideoTutorials = findViewById(R.id.btnVideoTutorials);
        btnGettingStarted = findViewById(R.id.btnGettingStarted);
        btnAccountSettings = findViewById(R.id.btnAccountSettings);
        faq1 = findViewById(R.id.faq1);
        faq2 = findViewById(R.id.faq2);
        faq3 = findViewById(R.id.faq3);
        btnStartLiveChat = findViewById(R.id.btnStartLiveChat);

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Live Chat
        btnLiveChat.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Live Chat...", Toast.LENGTH_SHORT).show();
        });

        // Email Support
        btnEmailSupport.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:support@markettwin.ai"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Support Request - MarketTwin AI");
            try {
                startActivity(Intent.createChooser(emailIntent, "Send email"));
            } catch (Exception e) {
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
            }
        });

        // User Guide
        btnUserGuide.setOnClickListener(v -> {
            Toast.makeText(this, "Opening User Guide...", Toast.LENGTH_SHORT).show();
        });

        // Video Tutorials
        btnVideoTutorials.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Video Tutorials...", Toast.LENGTH_SHORT).show();
        });

        // Getting Started
        btnGettingStarted.setOnClickListener(v -> {
            Toast.makeText(this, "Getting Started Guide", Toast.LENGTH_SHORT).show();
        });

        // Account Settings - navigate to Settings
        btnAccountSettings.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });

        // FAQ click handlers
        faq1.setOnClickListener(v -> {
            Toast.makeText(this, "Track competitors by adding them in your dashboard", Toast.LENGTH_LONG).show();
        });

        faq2.setOnClickListener(v -> {
            Toast.makeText(this, "We support Technology, Healthcare, Finance, Retail, and more!", Toast.LENGTH_LONG).show();
        });

        faq3.setOnClickListener(v -> {
            Toast.makeText(this, "Our AI predictions have 85%+ accuracy based on historical data", Toast.LENGTH_LONG).show();
        });

        // Start Live Chat button
        btnStartLiveChat.setOnClickListener(v -> {
            Toast.makeText(this, "Connecting to support agent...", Toast.LENGTH_SHORT).show();
        });
    }
}
