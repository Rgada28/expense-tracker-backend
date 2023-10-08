package com.rgada28.expensetracker.repository;

import com.rgada28.expensetracker.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAllByAppUserUserId(Integer userId);
}
