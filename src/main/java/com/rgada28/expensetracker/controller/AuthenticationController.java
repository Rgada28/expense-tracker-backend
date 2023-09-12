package com.rgada28.expensetracker.controller;


import com.rgada28.expensetracker.dto.LoginRequestDTO;
import com.rgada28.expensetracker.dto.RegistrationResponseDTO;
import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.dto.LoginResponseDTO;
import com.rgada28.expensetracker.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public RegistrationResponseDTO registerUser(@RequestBody @Valid AppUser user) {
        return authenticationService.registerUser(user.getUsername(), user.getPassword(), user.getEmail());

    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO body) throws BadCredentialsException {
        return authenticationService.login(body.username(), body.password());
    }


}
