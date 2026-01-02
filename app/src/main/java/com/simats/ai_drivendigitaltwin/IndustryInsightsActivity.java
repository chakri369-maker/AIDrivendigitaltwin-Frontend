package com.simats.ai_drivendigitaltwin;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class IndustryInsightsActivity extends AppCompatActivity {

    ImageView btnBack, imgSectorIcon;
    TextView tabTechnology, tabRetail, tabHealthcare;
    TextView txtSectorName, txtGrowth, txtCompanies, txtMarketCap, txtTrend;
    TextView txtMetric1Label, txtMetric1Value, txtMetric1Change;
    TextView txtMetric2Label, txtMetric2Value, txtMetric2Change;
    TextView txtMetric3Label, txtMetric3Value, txtMetric3Change;
    
    private String currentTab = "technology";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry_insights);

        // Initialize views
        btnBack = findViewById(R.id.btnBack);
        imgSectorIcon = findViewById(R.id.imgSectorIcon);
        
        tabTechnology = findViewById(R.id.tabTechnology);
        tabRetail = findViewById(R.id.tabRetail);
        tabHealthcare = findViewById(R.id.tabHealthcare);
        
        txtSectorName = findViewById(R.id.txtSectorName);
        txtGrowth = findViewById(R.id.txtGrowth);
        txtCompanies = findViewById(R.id.txtCompanies);
        txtMarketCap = findViewById(R.id.txtMarketCap);
        txtTrend = findViewById(R.id.txtTrend);
        
        txtMetric1Label = findViewById(R.id.txtMetric1Label);
        txtMetric1Value = findViewById(R.id.txtMetric1Value);
        txtMetric1Change = findViewById(R.id.txtMetric1Change);
        
        txtMetric2Label = findViewById(R.id.txtMetric2Label);
        txtMetric2Value = findViewById(R.id.txtMetric2Value);
        txtMetric2Change = findViewById(R.id.txtMetric2Change);
        
        txtMetric3Label = findViewById(R.id.txtMetric3Label);
        txtMetric3Value = findViewById(R.id.txtMetric3Value);
        txtMetric3Change = findViewById(R.id.txtMetric3Change);

        // Back button
        btnBack.setOnClickListener(v -> finish());
        
        // Tab click listeners
        tabTechnology.setOnClickListener(v -> selectTab("technology"));
        tabRetail.setOnClickListener(v -> selectTab("retail"));
        tabHealthcare.setOnClickListener(v -> selectTab("healthcare"));
        
        // Load default tab
        selectTab("technology");
    }
    
    private void selectTab(String tab) {
        currentTab = tab;
        
        // Reset all tabs
        tabTechnology.setBackgroundResource(R.drawable.card_bg);
        tabTechnology.setTextColor(Color.parseColor("#9CA3AF"));
        tabRetail.setBackgroundResource(R.drawable.card_bg);
        tabRetail.setTextColor(Color.parseColor("#9CA3AF"));
        tabHealthcare.setBackgroundResource(R.drawable.card_bg);
        tabHealthcare.setTextColor(Color.parseColor("#9CA3AF"));
        
        // Activate selected tab and load data
        switch (tab) {
            case "technology":
                tabTechnology.setBackgroundResource(R.drawable.option_selected);
                tabTechnology.setTextColor(Color.WHITE);
                loadTechnologyData();
                break;
            case "retail":
                tabRetail.setBackgroundResource(R.drawable.option_selected);
                tabRetail.setTextColor(Color.WHITE);
                loadRetailData();
                break;
            case "healthcare":
                tabHealthcare.setBackgroundResource(R.drawable.option_selected);
                tabHealthcare.setTextColor(Color.WHITE);
                loadHealthcareData();
                break;
        }
    }
    
    private void loadTechnologyData() {
        // Update sector card
        imgSectorIcon.setImageResource(R.drawable.ic_tech);
        imgSectorIcon.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.blue_500));
        txtSectorName.setText("Technology");
        txtGrowth.setText("+34.5%");
        txtCompanies.setText("1,247");
        txtMarketCap.setText("$4.2T");
        txtTrend.setText("↗ Strong");
        txtTrend.setTextColor(Color.parseColor("#10B981"));
        
        // Update metrics
        txtMetric1Label.setText("AI/ML Adoption");
        txtMetric1Value.setText("78%");
        txtMetric1Change.setText("+12%");
        
        txtMetric2Label.setText("Cloud Migration");
        txtMetric2Value.setText("65%");
        txtMetric2Change.setText("+8%");
        
        txtMetric3Label.setText("Cybersecurity Spend");
        txtMetric3Value.setText("$6.1B");
        txtMetric3Change.setText("+15%");
    }
    
    private void loadRetailData() {
        // Update sector card
        imgSectorIcon.setImageResource(R.drawable.ic_retail);
        imgSectorIcon.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
        txtSectorName.setText("Retail");
        txtGrowth.setText("+18.3%");
        txtCompanies.setText("3,892");
        txtMarketCap.setText("$2.8T");
        txtTrend.setText("↗ Strong");
        txtTrend.setTextColor(Color.parseColor("#10B981"));
        
        // Update metrics
        txtMetric1Label.setText("E-commerce Growth");
        txtMetric1Value.setText("23%");
        txtMetric1Change.setText("+5%");
        
        txtMetric2Label.setText("Store Traffic");
        txtMetric2Value.setText("2.4M");
        txtMetric2Change.setText("+3%");
        
        txtMetric3Label.setText("Online Sales");
        txtMetric3Value.setText("$880M");
        txtMetric3Change.setText("+18%");
    }
    
    private void loadHealthcareData() {
        // Update sector card
        imgSectorIcon.setImageResource(R.drawable.ic_health);
        imgSectorIcon.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_500));
        txtSectorName.setText("Healthcare");
        txtGrowth.setText("+24.8%");
        txtCompanies.setText("2,156");
        txtMarketCap.setText("$5.6T");
        txtTrend.setText("↗ Strong");
        txtTrend.setTextColor(Color.parseColor("#10B981"));
        
        // Update metrics
        txtMetric1Label.setText("Telemedicine Adoption");
        txtMetric1Value.setText("89%");
        txtMetric1Change.setText("+7%");
        
        txtMetric2Label.setText("HealthTech Investment");
        txtMetric2Value.setText("$45B");
        txtMetric2Change.setText("+22%");
        
        txtMetric3Label.setText("AI Diagnostics");
        txtMetric3Value.setText("67%");
        txtMetric3Change.setText("+9%");
    }
}
