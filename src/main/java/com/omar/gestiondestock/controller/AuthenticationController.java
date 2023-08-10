package com.omar.gestiondestock.controller;

import com.omar.gestiondestock.controller.api.AuthenticationApi;
import com.omar.gestiondestock.dto.auth.AuthenticationRequest;
import com.omar.gestiondestock.dto.auth.AuthenticationResponse;
import com.omar.gestiondestock.model.auth.ExtendedUser;
import com.omar.gestiondestock.service.auth.ApplicationUserDetailsService;
import com.omar.gestiondestock.utils.Constants;
import com.omar.gestiondestock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.AUTHENTICATION_ENDPOINT)
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }

}
