package com.simats.ai_drivendigitaltwin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    ImageView btnBack;
    TextView btnEdit;
    TextView txtProfileInitial, txtProfileName, txtProfileEmail;
    ProgressBar progressApi, progressReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        btnBack = findViewById(R.id.btnBack);
        btnEdit = findViewById(R.id.btnEdit);
        progressApi = findViewById(R.id.progressApi);
        progressReports = findViewById(R.id.progressReports);
        
        // Profile data views
        txtProfileInitial = findViewById(R.id.txtProfileInitial);
        txtProfileName = findViewById(R.id.txtProfileName);
        txtProfileEmail = findViewById(R.id.txtProfileEmail);

        // Load user data from SharedPreferences
        loadUserData();

        // Set progress for the progress bars
        progressApi.setProgress(49); // Example: 49%
        progressReports.setProgress(80); // Example: 80%

        btnBack.setOnClickListener(v -> {
            finish(); // Go back to the previous screen (Dashboard)
        });

        btnEdit.setOnClickListener(v -> {
            Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
            // You can navigate to an Edit Profile screen here
        });
    }
    
    private void loadUserData() {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String userName = prefs.getString("userName", "Guest User");
        String userEmail = prefs.getString("userEmail", "guest@example.com");
        
        // Set the profile data
        txtProfileName.setText(userName);
        txtProfileEmail.setText(userEmail);
        
        // Set the initial (first letter of name)
        if (!userName.isEmpty()) {
            txtProfileInitial.setText(String.valueOf(userName.charAt(0)).toUpperCase());
        }
    }
}
