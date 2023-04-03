package com.example.okta.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal final OidcUser oidcUser) {
        return "Welcome, " + oidcUser.getName();
    }

    @RequestMapping("/attributes")
    @ResponseBody
    public String attributes(@AuthenticationPrincipal final OidcUser oidcUser) {
        return oidcUser.getAttributes().toString();
    }

    @RequestMapping("/authorities")
    @ResponseBody
    public String authorities(@AuthenticationPrincipal final OidcUser oidcUser) {
        return oidcUser.getAuthorities().toString();
    }
}
