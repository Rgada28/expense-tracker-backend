package com.rgada28.expensetracker.repository;


import com.rgada28.expensetracker.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername(String username);
}
