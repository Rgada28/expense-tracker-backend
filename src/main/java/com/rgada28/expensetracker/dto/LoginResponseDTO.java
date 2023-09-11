package com.rgada28.expensetracker.dto;

import com.rgada28.expensetracker.model.AppUser;

public class LoginResponseDTO {
    private AppUser user;
    private String jwt;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(AppUser user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
