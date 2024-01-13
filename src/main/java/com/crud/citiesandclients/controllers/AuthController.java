package com.crud.citiesandclients.controllers;

import com.crud.citiesandclients.domain.user.AuthDTO;
import com.crud.citiesandclients.domain.user.LoginResponseDTO;
import com.crud.citiesandclients.domain.user.RegisterDTO;
import com.crud.citiesandclients.domain.user.User;
import com.crud.citiesandclients.infra.security.TokenService;
import com.crud.citiesandclients.repositories.UserRepository;
import com.crud.citiesandclients.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data) {
        String token = userService.login(data);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        userService.register(data);

        return ResponseEntity.noContent().build();
    }
}
