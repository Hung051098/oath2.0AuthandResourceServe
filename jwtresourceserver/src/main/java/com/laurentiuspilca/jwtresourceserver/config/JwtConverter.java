package com.laurentiuspilca.jwtresourceserver.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer{
	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
	}
	
}
