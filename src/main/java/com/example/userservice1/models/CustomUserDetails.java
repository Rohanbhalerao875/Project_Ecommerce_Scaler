package com.example.userservice1.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private List<CustomGrantedAuthority> authorities;

    public CustomUserDetails() {}

    public CustomUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getHashedPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        // In the granted authorities, we need to add the roles.
        this.authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new CustomGrantedAuthority(role));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    // Getters and setters

    public String getUsernameField() {
        return username;
    }

    public void setUsernameField(String username) {
        this.username = username;
    }

    public String getPasswordField() {
        return password;
    }

    public void setPasswordField(String password) {
        this.password = password;
    }

    public boolean isAccountNonExpiredField() {
        return accountNonExpired;
    }

    public void setAccountNonExpiredField(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLockedField() {
        return accountNonLocked;
    }

    public void setAccountNonLockedField(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpiredField() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpiredField(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabledField() {
        return enabled;
    }

    public void setEnabledField(boolean enabled) {
        this.enabled = enabled;
    }

    public List<CustomGrantedAuthority> getAuthoritiesField() {
        return authorities;
    }

    public void setAuthoritiesField(List<CustomGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
