package com.azad.hello.dto;

import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestDto {
    private String username;
    private String email;
    private String password;


    public RegistrationRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public RegistrationRequestDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
