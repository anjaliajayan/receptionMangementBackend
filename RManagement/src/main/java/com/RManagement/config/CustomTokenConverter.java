package com.RManagement.config;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomTokenConverter extends JwtAccessTokenConverter {

@Override
public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

    final Map<String, Object> additionalInfo = new HashMap<>();
    additionalInfo.put("customized", "true");
    User user = (User) authentication.getPrincipal();
//    additionalInfo.put("role", user.getAuthorities());
    additionalInfo.put("role", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

    return super.enhance(accessToken, authentication);
    }
} 
