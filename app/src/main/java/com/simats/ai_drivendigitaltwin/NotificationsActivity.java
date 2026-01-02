package com.simats.ai_drivendigitaltwin;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {

    ImageView btnBack;
    TextView btnMarkAllRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        btnBack = findViewById(R.id.btnBack);
        btnMarkAllRead = findViewById(R.id.btnMarkAllRead);

        // Back button
        btnBack.setOnClickListener(v -> finish());
        
        // Mark all read button
        btnMarkAllRead.setOnClickListener(v -> {
            Toast.makeText(this, "All notifications marked as read", Toast.LENGTH_SHORT).show();
        });
    }
}
