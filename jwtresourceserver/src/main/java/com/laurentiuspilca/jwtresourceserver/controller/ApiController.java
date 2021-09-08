package com.laurentiuspilca.jwtresourceserver.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api")
    public String hello(Authentication aut) {
		return "This is a SECURED resource. Authentication: " /*+ auth.getName() + "; Authorities: " + auth.getAuthorities()*/;
    }
}
