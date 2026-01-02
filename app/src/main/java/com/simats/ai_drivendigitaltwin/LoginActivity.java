package com.simats.ai_drivendigitaltwin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.simats.ai_drivendigitaltwin.model.ApiResponse;
import com.simats.ai_drivendigitaltwin.model.LoginRequest;
import com.simats.ai_drivendigitaltwin.model.LoginResponse;
import com.simats.ai_drivendigitaltwin.model.RegisterRequest;
import com.simats.ai_drivendigitaltwin.network.ApiClient;
import com.simats.ai_drivendigitaltwin.network.ApiService;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    TextView lblName;
    Button btnLogin;
    TextView txtAlready, txtToggleMode;
    
    private boolean isRegisterMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lblName = findViewById(R.id.lblName);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnEmail);
        txtAlready = findViewById(R.id.txtAlready);
        txtToggleMode = findViewById(R.id.txtToggleMode);

        btnLogin.setOnClickListener(v -> {
            if (isRegisterMode) {
                registerUser();
            } else {
                loginUser();
            }
        });
        
        // Toggle between Sign In and Register modes
        txtToggleMode.setOnClickListener(v -> {
            isRegisterMode = !isRegisterMode;
            updateUIMode();
        });
        
        // "Already signed in? Continue" - go directly to Dashboard
        txtAlready.setOnClickListener(v -> {
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        });
    }
    
    private void updateUIMode() {
        if (isRegisterMode) {
            // Show name field for registration
            lblName.setVisibility(View.VISIBLE);
            etName.setVisibility(View.VISIBLE);
            btnLogin.setText("Register  →");
            txtToggleMode.setText("Already have an account? Sign In");
        } else {
            // Hide name field for login
            lblName.setVisibility(View.GONE);
            etName.setVisibility(View.GONE);
            btnLogin.setText("Sign In  →");
            txtToggleMode.setText("Don't have an account? Register");
        }
    }
    
    private void registerUser() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        
        // Create register request with default role and industries
        RegisterRequest request = new RegisterRequest(
                name,
                email,
                password,
                "User",
                Arrays.asList("Technology")
        );
        
        apiService.registerUser(request).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getStatus().equals("success")) {
                        // Save user data to SharedPreferences
                        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("userName", name);
                        editor.putString("userEmail", email);
                        editor.putString("userRole", "User");
                        editor.putBoolean("isLoggedIn", true);
                        editor.putBoolean("isNewUser", true);
                        editor.apply();
                        
                        Toast.makeText(LoginActivity.this, 
                                "Registration successful!", 
                                Toast.LENGTH_SHORT).show();
                        
                        // Navigate to Role Selection screen
                        Intent intent = new Intent(LoginActivity.this, RoleSelectionActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this,
                                response.body().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Registration failed. Please try again.",
                            Toast.LENGTH_SHORT).show();
                }
            }
            
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,
                        "Network Error: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginUser() {

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Enter email & password", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);

        LoginRequest request = new LoginRequest(email, password);

        apiService.loginUser(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call,
                                   Response<LoginResponse> response) {

                if (response.isSuccessful() && response.body() != null) {

                    if (response.body().getStatus().equals("success")) {
                        // Save user data to SharedPreferences
                        if (response.body().getUser() != null) {
                            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("userName", response.body().getUser().name);
                            editor.putString("userEmail", response.body().getUser().email);
                            editor.putString("userRole", response.body().getUser().role);
                            editor.putBoolean("isLoggedIn", true);
                            editor.apply();
                        }
                        
                        Toast.makeText(LoginActivity.this,
                                "Login Successful", Toast.LENGTH_SHORT).show();
                        goToDashboard();
                    } else {
                        Toast.makeText(LoginActivity.this,
                                response.body().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Invalid server response",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,
                        "Network Error",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }
}
