package com.rgada28.expensetracker;

import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.model.Category;
import com.rgada28.expensetracker.model.Role;
import com.rgada28.expensetracker.repository.AppUserRepository;
import com.rgada28.expensetracker.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			List<Category> categories = new ArrayList<>();
			AppUser admin = new AppUser(1, "admin","admin@test.com",passwordEncoder.encode("password"), roles,categories);
			appUserRepository.save(admin);
		};
	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

}
