package com.rgada28.expensetracker.services;


import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username: "+username+" not found "));
    }

    public AppUser createUser(AppUser user){
        //TODO Add Validations
        return userRepository.saveAndFlush(user);
    }

    public AppUser updateUser(AppUser user,Integer userId) throws Exception {
        //Check whether the user exists
        getUserById(userId);
        //TODO Add Validations
        return userRepository.saveAndFlush(user);
    }

    public AppUser getUserById(Integer userid) throws Exception {
        return userRepository.findById(userid).orElseThrow(()-> new Exception("User record not found for following id:-"+ userid));
    }

    public void deleteUser(Integer userId){
        //TODO Add Validations
        userRepository.deleteById(userId);
    }
}
