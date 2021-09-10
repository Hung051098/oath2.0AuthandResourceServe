package com.laurentiuspilca.jwtresourceserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api")
    public String hello(Authentication aut) {
		return "This is a SECURED resource";
    }
    
    @RequestMapping(value="/api_admin")
    @PreAuthorize("hasAuthority('role_admin')")
    public String helloadmin(Authentication aut) {
		return "This is a SECURED resource admin";
    }

	@RequestMapping(value="/api_user")
	@PreAuthorize("hasAuthority('role_user')")
    public String hellouser(Authentication aut) {
		return "This is a SECURED resource user";
    }
}
