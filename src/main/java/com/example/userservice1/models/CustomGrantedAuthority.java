package com.example.userservice1.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {
    private String authority;

    public CustomGrantedAuthority() {}

    public CustomGrantedAuthority(Role role) {
        this.authority = role.getValue();
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    // Getter and Setter
    public String getAuthorityField() {
        return authority;
    }

    public void setAuthorityField(String authority) {
        this.authority = authority;
    }
}
