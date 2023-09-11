package com.rgada28.expensetracker;

import com.rgada28.expensetracker.model.AppUser;
import com.rgada28.expensetracker.model.Role;
import com.rgada28.expensetracker.repository.AppUserRepository;
import com.rgada28.expensetracker.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
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
			AppUser admin = new AppUser(1, "admin", passwordEncoder.encode("password"), roles);
			appUserRepository.save(admin);
		};
	}

}
