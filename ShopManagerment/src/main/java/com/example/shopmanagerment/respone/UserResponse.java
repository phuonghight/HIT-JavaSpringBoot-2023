package com.example.shopmanagerment.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String fullName;
    private String accessToken;
    private String refreshToken;
    private Collection<? extends GrantedAuthority> authorities;
}