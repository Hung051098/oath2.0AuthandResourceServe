package com.hung.resourceservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {


    @RequestMapping(value = "/profile", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ROLE_user')")
    public String hello() {
        return "hello";
    }

}
