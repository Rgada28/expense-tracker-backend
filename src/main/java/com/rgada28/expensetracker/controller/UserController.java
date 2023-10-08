package com.rgada28.expensetracker.controller;

import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.services.AppUserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final AppUserService appUserService;

    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/")
    public String helloUserController(){
        return "User access level";
    }

//TODO Use DTO to return the Response
    @GetMapping("/{userId}")
    public AppUser getUserById(@PathVariable Integer userId) throws Exception {
        return appUserService.getUserById(userId);
    }

    @PostMapping()
    public ResponseEntity<AppUser> registerUser(@Valid @RequestBody AppUser user)  {
        return new ResponseEntity<>(appUserService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public AppUser updateUser(@Valid @RequestBody AppUser user, @PathVariable Integer userId) throws Exception {
        return appUserService.updateUser(user,userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        appUserService.deleteUser(userId);
       return new ResponseEntity<>("User Deleted successfully", HttpStatus.OK);
    }
}
