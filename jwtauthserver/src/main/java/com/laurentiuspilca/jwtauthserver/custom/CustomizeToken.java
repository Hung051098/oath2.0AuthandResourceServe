package com.laurentiuspilca.jwtauthserver.custom;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.laurentiuspilca.jwtauthserver.entities.UserApp;
import com.laurentiuspilca.jwtauthserver.entities.UserDetailsImpl;


public class CustomizeToken  extends JwtAccessTokenConverter{
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//		UserApp user = (UserApp) authentication.getPrincipal();

		UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
		
		Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());

		info.put("email", user.getEmail());

		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);

		return super.enhance(customAccessToken, authentication);
	}
}
