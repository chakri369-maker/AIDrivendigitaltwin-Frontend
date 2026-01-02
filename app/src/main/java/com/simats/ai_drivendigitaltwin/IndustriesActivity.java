package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IndustriesActivity extends AppCompatActivity {

    LinearLayout indTech, indHealth, indRetail, indOther;
    ImageView imgTech, imgHealth, imgRetail, imgOther;
    TextView txtTech, txtHealth, txtRetail, txtOther;
    Button btnContinue;
    
    // List to store selected industries
    List<String> selectedIndustries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industries);

        indTech = findViewById(R.id.indTech);
        indHealth = findViewById(R.id.indHealth);
        indRetail = findViewById(R.id.indRetail);
        indOther = findViewById(R.id.indOther);

        imgTech = findViewById(R.id.imgTech);
        imgHealth = findViewById(R.id.imgHealth);
        imgRetail = findViewById(R.id.imgRetail);
        imgOther = findViewById(R.id.imgOther);
        
        txtTech = findViewById(R.id.txtTech);
        txtHealth = findViewById(R.id.txtHealth);
        txtRetail = findViewById(R.id.txtRetail);
        txtOther = findViewById(R.id.txtOther);

        btnContinue = findViewById(R.id.btnContinue);

        indTech.setOnClickListener(v -> toggleSelection("Technology", indTech, imgTech, txtTech));
        indHealth.setOnClickListener(v -> toggleSelection("Healthcare", indHealth, imgHealth, txtHealth));
        indRetail.setOnClickListener(v -> toggleSelection("Retail", indRetail, imgRetail, txtRetail));
        indOther.setOnClickListener(v -> {
             // Exclusive selection for Other
             if (selectedIndustries.contains("Other")) {
                 deselectIndustry("Other", indOther, imgOther, txtOther);
             } else {
                 // Deselect all others first
                 deselectAll();
                 selectIndustry("Other", indOther, imgOther, txtOther);
             }
        });

        btnContinue.setOnClickListener(v -> {
            if (selectedIndustries.isEmpty()) {
                Toast.makeText(this, "Please select at least one industry", Toast.LENGTH_SHORT).show();
            } else {
                // Save selected industries to SharedPreferences
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putStringSet("selectedIndustries", new HashSet<>(selectedIndustries));
                editor.apply();
                
                Toast.makeText(this, "Selected: " + selectedIndustries.toString(), Toast.LENGTH_SHORT).show();
                // Navigate to Alert Preferences Screen
                Intent intent = new Intent(IndustriesActivity.this, AlertPreferencesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toggleSelection(String industry, LinearLayout layout, ImageView icon, TextView text) {
        if (selectedIndustries.contains("Other")) {
            // If Other is selected, deselect it when selecting another industry
            deselectIndustry("Other", indOther, imgOther, txtOther);
        }

        if (selectedIndustries.contains(industry)) {
            deselectIndustry(industry, layout, icon, text);
        } else {
            selectIndustry(industry, layout, icon, text);
        }
    }

    private void selectIndustry(String industry, LinearLayout layout, ImageView icon, TextView text) {
        selectedIndustries.add(industry);
        layout.setBackgroundResource(R.drawable.option_selected);
        icon.setBackgroundResource(R.drawable.bg_icon_selected);
        text.setTextColor(getResources().getColor(android.R.color.white));
        text.setTypeface(null, android.graphics.Typeface.BOLD);
    }

    private void deselectIndustry(String industry, LinearLayout layout, ImageView icon, TextView text) {
        selectedIndustries.remove(industry);
        layout.setBackgroundResource(R.drawable.option_unselected);
        icon.setBackgroundResource(R.drawable.bg_icon_unselected);
        text.setTextColor(getResources().getColor(android.R.color.darker_gray)); // Use a specific color if needed
        text.setTypeface(null, android.graphics.Typeface.NORMAL);
    }
    
    private void deselectAll() {
        if (selectedIndustries.contains("Technology")) deselectIndustry("Technology", indTech, imgTech, txtTech);
        if (selectedIndustries.contains("Healthcare")) deselectIndustry("Healthcare", indHealth, imgHealth, txtHealth);
        if (selectedIndustries.contains("Retail")) deselectIndustry("Retail", indRetail, imgRetail, txtRetail);
        if (selectedIndustries.contains("Other")) deselectIndustry("Other", indOther, imgOther, txtOther);
        selectedIndustries.clear();
    }
}
