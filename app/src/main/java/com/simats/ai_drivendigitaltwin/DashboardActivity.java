package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DashboardActivity extends AppCompatActivity {

    TextView txtDate;
    ImageView btnProfile;
    LinearLayout navSettings, navTrends, navCompetitors, navAlerts, cardActiveTrends, cardMarketActivity, cardCompetitors, cardSentiment, actionInsights, cardAIReplica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtDate = findViewById(R.id.txtDate);
        btnProfile = findViewById(R.id.btnProfile);
        navSettings = findViewById(R.id.navSettings);
        navTrends = findViewById(R.id.navTrends);
        navCompetitors = findViewById(R.id.navCompetitors);
        navAlerts = findViewById(R.id.navAlerts);
        cardActiveTrends = findViewById(R.id.cardActiveTrends);
        cardMarketActivity = findViewById(R.id.cardMarketActivity);
        cardCompetitors = findViewById(R.id.cardCompetitors);
        cardSentiment = findViewById(R.id.cardSentiment);
        actionInsights = findViewById(R.id.actionInsights);
        cardAIReplica = findViewById(R.id.cardAIReplica);

        // Update Date to IST
        updateDate();
        
        // Navigate to UserProfileActivity when profile icon is clicked
        btnProfile.setOnClickListener(v -> {
            startActivity(new Intent(this, UserProfileActivity.class));
        });
        
        // Navigate to SettingsActivity when settings is clicked
        navSettings.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsActivity.class));
        });
        
        // Navigate to TrendExplorerActivity when Trends is clicked
        navTrends.setOnClickListener(v -> {
            startActivity(new Intent(this, TrendExplorerActivity.class));
        });
        
        // Navigate to CompetitorsActivity when Competitors nav is clicked
        navCompetitors.setOnClickListener(v -> {
            startActivity(new Intent(this, CompetitorsActivity.class));
        });
        
        // Navigate to NotificationsActivity when Alerts is clicked
        navAlerts.setOnClickListener(v -> {
            startActivity(new Intent(this, NotificationsActivity.class));
        });
        
        // Navigate to CompetitorsActivity when Competitors card is clicked
        cardCompetitors.setOnClickListener(v -> {
            startActivity(new Intent(this, CompetitorsActivity.class));
        });
        
        // Navigate to TrendExplorerActivity when Active Trends card is clicked
        cardActiveTrends.setOnClickListener(v -> {
            startActivity(new Intent(this, TrendExplorerActivity.class));
        });
        
        // Navigate to LiveScrapingActivity when Market Activity card is clicked
        cardMarketActivity.setOnClickListener(v -> {
            startActivity(new Intent(this, LiveScrapingActivity.class));
        });
        
        // Navigate to ConsumerInsightsActivity when Sentiment card is clicked
        cardSentiment.setOnClickListener(v -> {
            startActivity(new Intent(this, ConsumerInsightsActivity.class));
        });
        
        // Navigate to IndustryInsightsActivity when Insights Quick Action is clicked
        actionInsights.setOnClickListener(v -> {
            startActivity(new Intent(this, IndustryInsightsActivity.class));
        });
        
        // Navigate to AIReplicaActivity when AI Replica card is clicked
        cardAIReplica.setOnClickListener(v -> {
            startActivity(new Intent(this, AIReplicaActivity.class));
        });
    }

    private void updateDate() {
        try {
            // Format: "Friday, December 12"
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH);
            
            // Set TimeZone to IST (Indian Standard Time)
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
            
            String currentDate = sdf.format(new Date());
            txtDate.setText(currentDate);
        } catch (Exception e) {
            e.printStackTrace();
            txtDate.setText("Today"); // Fallback
        }
    }
}
