package com.simats.ai_drivendigitaltwin.network;

import com.simats.ai_drivendigitaltwin.model.LoginRequest;
import com.simats.ai_drivendigitaltwin.model.LoginResponse;

import com.simats.ai_drivendigitaltwin.model.RegisterRequest;
import com.simats.ai_drivendigitaltwin.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login.php")
    Call<LoginResponse> loginUser(@Body LoginRequest request);
    @POST("registration.php")
    Call<ApiResponse> registerUser(@Body RegisterRequest request);
}
