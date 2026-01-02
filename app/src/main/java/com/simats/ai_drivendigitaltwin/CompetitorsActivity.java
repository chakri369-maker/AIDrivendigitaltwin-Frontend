package com.simats.ai_drivendigitaltwin;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simats.ai_drivendigitaltwin.adapter.CompetitorAdapter;
import com.simats.ai_drivendigitaltwin.model.Competitor;

import java.util.ArrayList;
import java.util.List;

public class CompetitorsActivity extends AppCompatActivity {

    ImageView btnBack, btnFilter;
    EditText searchCompetitors;
    RecyclerView recyclerCompetitors;
    CompetitorAdapter adapter;
    
    List<Competitor> allCompetitors = new ArrayList<>();
    List<Competitor> filteredCompetitors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitors);

        btnBack = findViewById(R.id.btnBack);
        btnFilter = findViewById(R.id.btnFilter);
        searchCompetitors = findViewById(R.id.searchCompetitors);
        recyclerCompetitors = findViewById(R.id.recyclerCompetitors);

        // Initialize competitors data
        initializeCompetitors();
        
        // Copy all to filtered list
        filteredCompetitors.addAll(allCompetitors);
        
        // Setup RecyclerView
        recyclerCompetitors.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CompetitorAdapter(filteredCompetitors);
        recyclerCompetitors.setAdapter(adapter);

        // Back button
        btnBack.setOnClickListener(v -> finish());
        
        // Filter button
        btnFilter.setOnClickListener(v -> {
            Toast.makeText(this, "Filter options coming soon", Toast.LENGTH_SHORT).show();
        });

        // Search functionality
        searchCompetitors.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterCompetitors(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    
    private void initializeCompetitors() {
        // Add sample competitors
        allCompetitors.add(new Competitor(1, "TechFlow AI", "AI Tools", 95, "+5%", true));
        allCompetitors.add(new Competitor(2, "DataSync Pro", "Data Analytics", 89, "+2%", true));
        allCompetitors.add(new Competitor(3, "CloudBase", "Cloud Services", 87, "-3%", false));
        allCompetitors.add(new Competitor(4, "MarketPulse", "Marketing", 84, "+8%", true));
        allCompetitors.add(new Competitor(5, "AutoSync", "Automation", 82, "+4%", true));
        allCompetitors.add(new Competitor(6, "SecureNet", "Cybersecurity", 80, "+6%", true));
        allCompetitors.add(new Competitor(7, "FinanceHub", "FinTech", 78, "-2%", false));
        allCompetitors.add(new Competitor(8, "HealthTech", "Healthcare IT", 76, "+3%", true));
        allCompetitors.add(new Competitor(9, "RetailPro", "E-commerce", 74, "+1%", true));
        allCompetitors.add(new Competitor(10, "EduLearn", "EdTech", 72, "-1%", false));
    }
    
    private void filterCompetitors(String query) {
        List<Competitor> searchFiltered = new ArrayList<>();
        
        for (Competitor competitor : allCompetitors) {
            if (competitor.getName().toLowerCase().contains(query.toLowerCase()) ||
                competitor.getCategory().toLowerCase().contains(query.toLowerCase())) {
                searchFiltered.add(competitor);
            }
        }
        
        adapter.updateCompetitors(searchFiltered);
    }
}
