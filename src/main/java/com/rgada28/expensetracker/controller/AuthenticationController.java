package com.rgada28.expensetracker.controller;


import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.dto.LoginResponseDTO;
import com.rgada28.expensetracker.dto.RegistrationDTO;
import com.rgada28.expensetracker.services.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService=authenticationService;
    }

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody RegistrationDTO body){
        System.out.println(body);
        return authenticationService.registerUser(body.username(),body.password(), body.email());

    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody RegistrationDTO body){
        System.out.println(body);
        return authenticationService.login(body.username(),body.password());
    }


}
