package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RoleSelectionActivity extends AppCompatActivity {

    LinearLayout roleStartupFounder, roleInvestor, roleMarketer, roleStudent;
    ImageView imgStartupFounder, imgInvestor, imgMarketer, imgStudent;
    TextView txtStartupFounder, txtInvestor, txtMarketer, txtStudent;
    Button btnContinue;
    
    String selectedRole = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);

        // Initialize views
        roleStartupFounder = findViewById(R.id.roleStartupFounder);
        roleInvestor = findViewById(R.id.roleInvestor);
        roleMarketer = findViewById(R.id.roleMarketer);
        roleStudent = findViewById(R.id.roleStudent);

        imgStartupFounder = findViewById(R.id.imgStartupFounder);
        imgInvestor = findViewById(R.id.imgInvestor);
        imgMarketer = findViewById(R.id.imgMarketer);
        imgStudent = findViewById(R.id.imgStudent);

        txtStartupFounder = findViewById(R.id.txtStartupFounder);
        txtInvestor = findViewById(R.id.txtInvestor);
        txtMarketer = findViewById(R.id.txtMarketer);
        txtStudent = findViewById(R.id.txtStudent);

        btnContinue = findViewById(R.id.btnContinue);

        // Set click listeners for role options
        roleStartupFounder.setOnClickListener(v -> selectRole("Startup Founder", 
                roleStartupFounder, imgStartupFounder, txtStartupFounder));
        
        roleInvestor.setOnClickListener(v -> selectRole("Investor", 
                roleInvestor, imgInvestor, txtInvestor));
        
        roleMarketer.setOnClickListener(v -> selectRole("Marketer", 
                roleMarketer, imgMarketer, txtMarketer));
        
        roleStudent.setOnClickListener(v -> selectRole("Student/Researcher", 
                roleStudent, imgStudent, txtStudent));

        // Continue button
        btnContinue.setOnClickListener(v -> {
            if (selectedRole == null) {
                Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show();
            } else {
                // Save selected role to SharedPreferences
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("userRole", selectedRole);
                editor.apply();
                
                // Navigate to Industries screen
                Intent intent = new Intent(RoleSelectionActivity.this, IndustriesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void selectRole(String role, LinearLayout layout, ImageView icon, TextView text) {
        // Reset all options
        resetAllOptions();
        
        // Select the clicked option
        selectedRole = role;
        layout.setBackgroundResource(R.drawable.option_selected);
        icon.setBackgroundResource(R.drawable.bg_icon_selected);
        text.setTextColor(getResources().getColor(android.R.color.white));
    }

    private void resetAllOptions() {
        // Reset Startup Founder
        roleStartupFounder.setBackgroundResource(R.drawable.option_unselected);
        imgStartupFounder.setBackgroundResource(R.drawable.bg_icon_unselected);
        txtStartupFounder.setTextColor(getResources().getColor(android.R.color.darker_gray));

        // Reset Investor
        roleInvestor.setBackgroundResource(R.drawable.option_unselected);
        imgInvestor.setBackgroundResource(R.drawable.bg_icon_unselected);
        txtInvestor.setTextColor(getResources().getColor(android.R.color.darker_gray));

        // Reset Marketer
        roleMarketer.setBackgroundResource(R.drawable.option_unselected);
        imgMarketer.setBackgroundResource(R.drawable.bg_icon_unselected);
        txtMarketer.setTextColor(getResources().getColor(android.R.color.darker_gray));

        // Reset Student
        roleStudent.setBackgroundResource(R.drawable.option_unselected);
        imgStudent.setBackgroundResource(R.drawable.bg_icon_unselected);
        txtStudent.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}
