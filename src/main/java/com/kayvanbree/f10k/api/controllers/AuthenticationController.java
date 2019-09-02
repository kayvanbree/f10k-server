package com.kayvanbree.f10k.api.controllers;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AuthenticationController {

    @Value("${F10K_CLIENT_ID}")
    private String clientId;

    @Value("${F10K_CLIENT_SECRET}")
    private String clientSecret;

    @Value("${F10K_CLIENT_REDIRECT_URI}")
    private String redirectUri;

    @GetMapping("/login")
    public Object login(@RequestParam() String code) throws HttpException {
        System.out.println(code);
        System.out.println(clientId);
        System.out.println(clientSecret);
        System.out.println(redirectUri);

        try {
            final SpotifyApi spotifyApi = new SpotifyApi.Builder()
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .setRedirectUri(SpotifyHttpManager.makeUri(redirectUri))
                    .build();

            final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
                    .build();
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());

            Map<String, String> response = new HashMap<>();
            response.put("access_token", authorizationCodeCredentials.getAccessToken());
            response.put("refresh_token", authorizationCodeCredentials.getRefreshToken());
            response.put("expires_in", authorizationCodeCredentials.getExpiresIn().toString());

            return response;


        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        throw new HttpException("Could not login at Spotify");
    }

    @GetMapping("/refresh")
    public Object refresh(@RequestParam() String token) throws HttpException  {
        System.out.println(token);

        try {
            final SpotifyApi spotifyApi = new SpotifyApi.Builder()
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .setRefreshToken(token)
                    .build();
            final AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
                    .build();
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();

            System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());

            Map<String, String> response = new HashMap<>();
            response.put("access_token", authorizationCodeCredentials.getAccessToken());
            response.put("refresh_token", authorizationCodeCredentials.getRefreshToken());
            response.put("expires_in", authorizationCodeCredentials.getExpiresIn().toString());

            return response;


        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
        throw new HttpException("Could not login at Spotify");
    }
}
