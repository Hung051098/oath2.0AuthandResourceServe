package com.laurentiuspilca.jwtauthserver.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.laurentiuspilca.jwtauthserver.entities.UserApp;
import com.laurentiuspilca.jwtauthserver.repositories.UserAppRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DefaultAuthenticationProvider implements AuthenticationProvider{

    private UserAppRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<UserApp> User = userRepository.findByUsername(authentication.getName());
        if(User.isPresent()) {
        	UserApp user = User.get();
            String username = authentication.getName();
            String password = (String)authentication.getCredentials();
            if(username.equalsIgnoreCase(user.getUsername()) &&
                password.equalsIgnoreCase(user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()
                );
            }
        }

        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
