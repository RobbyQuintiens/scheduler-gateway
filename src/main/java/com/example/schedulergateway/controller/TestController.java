package com.example.schedulergateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final static String EMAIL_CLAIM = "https://example.com/email";

    @GetMapping("/gateway")
    public ResponseEntity<String> officePoint(@AuthenticationPrincipal Jwt principal) {
        String test = principal.getClaims().toString();
        return new ResponseEntity<>("Welcome " + test, HttpStatus.OK);
    }
}
