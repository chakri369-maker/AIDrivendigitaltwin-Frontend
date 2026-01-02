package com.simats.ai_drivendigitaltwin;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.adapter.MarketActivityAdapter;
import com.simats.ai_drivendigitaltwin.model.MarketActivity;

import java.util.ArrayList;
import java.util.List;

public class LiveScrapingActivity extends AppCompatActivity {

    ImageView btnBack;
    RecyclerView recyclerActivities;
    MarketActivityAdapter adapter;
    
    List<MarketActivity> activities = new ArrayList<>();

    // Dot colors
    private static final String COLOR_WHITE = "#FFFFFF";
    private static final String COLOR_BLUE = "#3B82F6";
    private static final String COLOR_PURPLE = "#8B5CF6";
    private static final String COLOR_GREEN = "#10B981";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_scraping);

        btnBack = findViewById(R.id.btnBack);
        recyclerActivities = findViewById(R.id.recyclerActivities);

        // Initialize activities data
        initializeActivities();
        
        // Setup RecyclerView
        recyclerActivities.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MarketActivityAdapter(activities);
        recyclerActivities.setAdapter(adapter);

        // Back button
        btnBack.setOnClickListener(v -> finish());
    }
    
    private void initializeActivities() {
        // Sample market activities matching the design
        activities.add(new MarketActivity(
            "LinkedIn", "Release", "New activity detected", "Just now", COLOR_WHITE
        ));
        
        activities.add(new MarketActivity(
            "GitHub", "Update", "New activity detected", "Just now", COLOR_BLUE
        ));
        
        activities.add(new MarketActivity(
            "ProductHunt", "Update", "New activity detected", "Just now", COLOR_PURPLE
        ));
        
        activities.add(new MarketActivity(
            "ProductHunt", "Release", "New activity detected", "Just now", COLOR_PURPLE
        ));
        
        activities.add(new MarketActivity(
            "ProductHunt", "Update", "New activity detected", "Just now", COLOR_GREEN
        ));
        
        activities.add(new MarketActivity(
            "Amazon", "Price Change", "iPhone 15 Pro - $50", "Just now", COLOR_BLUE
        ));
        
        activities.add(new MarketActivity(
            "Twitter", "Trending", "AI Tools discussion", "2 min ago", COLOR_BLUE
        ));
        
        activities.add(new MarketActivity(
            "TechCrunch", "News", "New startup funding round", "5 min ago", COLOR_GREEN
        ));
        
        activities.add(new MarketActivity(
            "Reddit", "Discussion", "Market analysis thread", "10 min ago", COLOR_PURPLE
        ));
        
        activities.add(new MarketActivity(
            "Bloomberg", "Report", "Q4 earnings preview", "15 min ago", COLOR_WHITE
        ));
    }
}
