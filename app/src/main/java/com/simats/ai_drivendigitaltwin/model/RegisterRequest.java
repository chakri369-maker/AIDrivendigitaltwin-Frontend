package com.simats.ai_drivendigitaltwin.model;



import java.util.List;

public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String role;
    private List<String> industries;

    public RegisterRequest(String name,
                           String email,
                           String password,
                           String role,
                           List<String> industries) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.industries = industries;
    }
}
