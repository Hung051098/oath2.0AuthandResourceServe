package com.hung.oauthresourcersa.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRest {

	@RequestMapping(value="/api")
	@PreAuthorize("hasAuthority('role_admin')")
	public String success() {
		return "SUCCESS";
	}
	
	
	@RequestMapping(value="/api2")
	public String api2() {
		return "api2";
	}
	

	@PreAuthorize("hasAuthority('role_user')")
	@RequestMapping(value="/api3")
	public String api3() {
		return "api3";
	}
}
