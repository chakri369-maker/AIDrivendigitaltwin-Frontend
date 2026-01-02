package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.simats.ai_drivendigitaltwin.model.ApiResponse;
import com.simats.ai_drivendigitaltwin.model.RegisterRequest;
import com.simats.ai_drivendigitaltwin.network.ApiClient;
import com.simats.ai_drivendigitaltwin.network.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    EditText etName, etEmail, etPassword;
    Button btnContinue;

    LinearLayout optFounder, optInvestor, optMarketer, optStudent;
    ImageView imgFounder, imgInvestor, imgMarketer, imgStudent;
    TextView txtFounder, txtInvestor, txtMarketer, txtStudent;

    String selectedRole = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnContinue = findViewById(R.id.btnContinue);

        optFounder = findViewById(R.id.optFounder);
        optInvestor = findViewById(R.id.optInvestor);
        optMarketer = findViewById(R.id.optMarketer);
        optStudent = findViewById(R.id.optStudent);

        imgFounder = findViewById(R.id.imgFounder);
        imgInvestor = findViewById(R.id.imgInvestor);
        imgMarketer = findViewById(R.id.imgMarketer);
        imgStudent = findViewById(R.id.imgStudent);

        txtFounder = findViewById(R.id.txtFounder);
        txtInvestor = findViewById(R.id.txtInvestor);
        txtMarketer = findViewById(R.id.txtMarketer);
        txtStudent = findViewById(R.id.txtStudent);

        // ROLE SELECTION LISTENERS (values must match database enum)
        optFounder.setOnClickListener(v ->
                selectRole("startup_founder", optFounder, imgFounder, txtFounder));

        optInvestor.setOnClickListener(v ->
                selectRole("investor", optInvestor, imgInvestor, txtInvestor));

        optMarketer.setOnClickListener(v ->
                selectRole("marketer", optMarketer, imgMarketer, txtMarketer));

        optStudent.setOnClickListener(v ->
                selectRole("student_researcher", optStudent, imgStudent, txtStudent));

        btnContinue.setOnClickListener(v -> submitProfile());
    }

    // Role selection handler
    private void selectRole(String role,
                            LinearLayout layout,
                            ImageView icon,
                            TextView text) {
        resetSelections();
        selectedRole = role;
        layout.setBackgroundResource(R.drawable.option_selected);
        icon.setBackgroundResource(R.drawable.bg_icon_selected);
        text.setTypeface(null, android.graphics.Typeface.BOLD);
    }

    // Reset all role selections
    private void resetSelections() {
        optFounder.setBackgroundResource(R.drawable.option_unselected);
        optInvestor.setBackgroundResource(R.drawable.option_unselected);
        optMarketer.setBackgroundResource(R.drawable.option_unselected);
        optStudent.setBackgroundResource(R.drawable.option_unselected);

        imgFounder.setBackgroundResource(R.drawable.bg_icon_unselected);
        imgInvestor.setBackgroundResource(R.drawable.bg_icon_unselected);
        imgMarketer.setBackgroundResource(R.drawable.bg_icon_unselected);
        imgStudent.setBackgroundResource(R.drawable.bg_icon_unselected);

        txtFounder.setTypeface(null, android.graphics.Typeface.NORMAL);
        txtInvestor.setTypeface(null, android.graphics.Typeface.NORMAL);
        txtMarketer.setTypeface(null, android.graphics.Typeface.NORMAL);
        txtStudent.setTypeface(null, android.graphics.Typeface.NORMAL);
    }

    // Submit Profile Data
    private void submitProfile() {

        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedRole.isEmpty()) {
            Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create the request object
        RegisterRequest request = new RegisterRequest(
                name,
                email,
                password,
                selectedRole,
                new ArrayList<>()
        );

        // Get API Service
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        // Make the API call
        apiService.registerUser(request).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Success case
                    ApiResponse apiResponse = response.body();
                    Toast.makeText(ProfileActivity.this, apiResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    if ("success".equals(apiResponse.getStatus())) {
                        Intent intent = new Intent(ProfileActivity.this, IndustriesActivity.class);
                        startActivity(intent);
                    }
                } else {
                    // Error case: Server returned an error (e.g., 404, 500)
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e(TAG, "Server Error: " + errorBody);
                        Toast.makeText(ProfileActivity.this, "Server Error: " + errorBody, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Log.e(TAG, "Error parsing error body", e);
                        Toast.makeText(ProfileActivity.this, "An unknown server error occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Failure case: Network error or other issue
                Log.e(TAG, "Network Failure: ", t);
                Toast.makeText(ProfileActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
