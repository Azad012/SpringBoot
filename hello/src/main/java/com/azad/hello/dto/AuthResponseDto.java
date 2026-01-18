package com.azad.hello.dto;

public class AuthResponseDto {
    private Long id;
    private String username;

    private String email;

    private String successMess;

    public AuthResponseDto(Long id, String username, String email, String successMess) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.successMess = successMess;
    }

    public AuthResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSuccessMess() {
        return successMess;
    }

    public void setSuccessMess(String successMess) {
        this.successMess = successMess;
    }


}
