package com.hung.oauthresourcersa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableResourceServer
@RestController
public class OauthresourcersaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthresourcersaApplication.class, args);
	}
	@RequestMapping(value="/api")
	@PreAuthorize("hasAuthority('role_admin')")
	public String success() {
		return "SUCCESS";
	}
}
