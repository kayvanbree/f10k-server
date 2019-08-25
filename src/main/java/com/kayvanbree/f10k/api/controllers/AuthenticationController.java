package com.kayvanbree.f10k.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    @PostMapping("/login/{code}")
    public Object login(String code) {
        final String uri = "https://accounts.spotify.com/api/token";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }
}
