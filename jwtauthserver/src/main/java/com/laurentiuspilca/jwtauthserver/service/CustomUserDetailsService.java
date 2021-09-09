package com.laurentiuspilca.jwtauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.laurentiuspilca.jwtauthserver.entities.UserApp;
import com.laurentiuspilca.jwtauthserver.repositories.UserAppRepository;

@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserAppRepository userAppRepository;

	@Override
	public UserDetails loadUserByUsername(String input) {
		UserApp user = userAppRepository.findByUsernameApp(input);

		if (user == null)
			throw new BadCredentialsException("Bad credentials");

		new AccountStatusUserDetailsChecker().check(user);
		return user;
	}
}
