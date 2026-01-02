package com.simats.ai_drivendigitaltwin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.adapter.TrendAdapter;
import com.simats.ai_drivendigitaltwin.model.Trend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrendExplorerActivity extends AppCompatActivity {

    ImageView btnBack;
    EditText searchTrends;
    RecyclerView recyclerTrends;
    TrendAdapter adapter;
    
    List<Trend> allTrends = new ArrayList<>();
    List<Trend> filteredTrends = new ArrayList<>();
    Set<String> userIndustries = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_explorer);

        btnBack = findViewById(R.id.btnBack);
        searchTrends = findViewById(R.id.searchTrends);
        recyclerTrends = findViewById(R.id.recyclerTrends);

        // Load user's selected industries
        loadUserIndustries();
        
        // Initialize trends data
        initializeTrends();
        
        // Filter trends based on user industries
        filterTrendsByIndustry();
        
        // Setup RecyclerView
        recyclerTrends.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TrendAdapter(filteredTrends);
        recyclerTrends.setAdapter(adapter);

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Search functionality
        searchTrends.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterTrends(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    
    private void loadUserIndustries() {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        Set<String> industries = prefs.getStringSet("selectedIndustries", null);
        
        if (industries != null && !industries.isEmpty()) {
            userIndustries.addAll(industries);
        } else {
            // Default industries if none selected
            userIndustries.add("Technology");
            userIndustries.add("Healthcare");
            userIndustries.add("Retail");
            userIndustries.add("Fashion");
        }
    }
    
    private void initializeTrends() {
        // Technology trends
        allTrends.add(new Trend("AI-Powered Tools", "Technology", 94, "+23%", true));
        allTrends.add(new Trend("Remote Work Software", "Technology", 82, "-5%", false));
        allTrends.add(new Trend("Cloud Computing", "Technology", 91, "+15%", true));
        allTrends.add(new Trend("Cybersecurity Solutions", "Technology", 88, "+18%", true));
        allTrends.add(new Trend("Blockchain Applications", "Technology", 72, "-8%", false));
        
        // Healthcare trends
        allTrends.add(new Trend("Telemedicine Platforms", "Healthcare", 88, "+12%", true));
        allTrends.add(new Trend("Digital Health Records", "Healthcare", 79, "+8%", true));
        allTrends.add(new Trend("Wearable Health Tech", "Healthcare", 85, "+20%", true));
        allTrends.add(new Trend("Mental Health Apps", "Healthcare", 90, "+25%", true));
        
        // Retail trends
        allTrends.add(new Trend("Sustainable Retail", "Retail", 86, "+14%", true));
        allTrends.add(new Trend("E-commerce Platforms", "Retail", 92, "+19%", true));
        allTrends.add(new Trend("Buy Now Pay Later", "Retail", 77, "-3%", false));
        allTrends.add(new Trend("Social Commerce", "Retail", 83, "+11%", true));
        
        // Fashion trends
        allTrends.add(new Trend("Sustainable Fashion", "Fashion", 87, "+18%", true));
        allTrends.add(new Trend("Virtual Try-On", "Fashion", 75, "+9%", true));
        allTrends.add(new Trend("Resale Market", "Fashion", 81, "+16%", true));
        
        // Finance trends
        allTrends.add(new Trend("Digital Banking", "Finance", 89, "+21%", true));
        allTrends.add(new Trend("Cryptocurrency", "Finance", 68, "-12%", false));
        allTrends.add(new Trend("Robo Advisors", "Finance", 74, "+7%", true));
        
        // Other trends
        allTrends.add(new Trend("Electric Vehicles", "Automotive", 93, "+28%", true));
        allTrends.add(new Trend("Smart Home Devices", "Consumer Tech", 84, "+13%", true));
        allTrends.add(new Trend("EdTech Platforms", "Education", 86, "+17%", true));
    }
    
    private void filterTrendsByIndustry() {
        filteredTrends.clear();
        
        for (Trend trend : allTrends) {
            // Show trends that match user's selected industries
            // Also show "Other" category trends for variety
            if (userIndustries.contains(trend.getIndustry()) || 
                userIndustries.contains("Other")) {
                filteredTrends.add(trend);
            }
        }
        
        // If no matching trends, show all (for demo purposes)
        if (filteredTrends.isEmpty()) {
            filteredTrends.addAll(allTrends);
        }
    }
    
    private void filterTrends(String query) {
        List<Trend> searchFiltered = new ArrayList<>();
        
        for (Trend trend : filteredTrends) {
            if (trend.getName().toLowerCase().contains(query.toLowerCase()) ||
                trend.getIndustry().toLowerCase().contains(query.toLowerCase())) {
                searchFiltered.add(trend);
            }
        }
        
        adapter.updateTrends(searchFiltered);
    }
}
