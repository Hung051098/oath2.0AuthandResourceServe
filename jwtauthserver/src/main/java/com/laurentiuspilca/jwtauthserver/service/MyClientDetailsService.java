package com.laurentiuspilca.jwtauthserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.laurentiuspilca.jwtauthserver.entities.Client;
import com.laurentiuspilca.jwtauthserver.repositories.ClientRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Primary
@Log4j2
public class MyClientDetailsService implements ClientDetailsService {
//	@Override
//	@Cacheable("ClientDetails")
//	public ClientDetails loadClientByClientId(String clientId) {
//
//        log.info("Got called!");
//		return null;
//	}
	@Autowired
	ClientRepository clientRepository;
	@Override
		public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		log.info("loadClientByClientId called with id {}. Stack trace: {}", clientId);
		    Client oAuthClientDetails = clientRepository.findByClientId(clientId);
		   if (oAuthClientDetails!= null) {
			  return oAuthClientDetails;
		   }
		   throw new BadCredentialsException("Client bad credentials");
		}
}