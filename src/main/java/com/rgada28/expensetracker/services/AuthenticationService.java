package com.rgada28.expensetracker.services;


import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.dto.LoginResponseDTO;
import com.rgada28.expensetracker.model.Category;
import com.rgada28.expensetracker.model.Role;
import com.rgada28.expensetracker.repository.AppUserRepository;
import com.rgada28.expensetracker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    public AppUser registerUser(String username, String password, String email){
        String encodedPassword = encoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        List<Category> categories = new ArrayList<>();
        return userRepository.save(new AppUser(0,username,email,encodedPassword,authorities,categories));
    }

    public LoginResponseDTO login(String username, String password){
        LoginResponseDTO loginResponseDTO;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );
            String token = tokenService.generateJwt(auth);
            return new LoginResponseDTO(userRepository.findByUsername(username).get(),token);
        }catch (AuthenticationException ex){
            return  new LoginResponseDTO(null,"");
        }
    }
}
