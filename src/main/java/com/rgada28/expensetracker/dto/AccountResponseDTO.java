package com.rgada28.expensetracker.dto;

import com.rgada28.expensetracker.model.Account;
import org.modelmapper.ModelMapper;

public record AccountResponseDTO(
        Integer accountId,
        String accountName,
        String accountNumber,
        double balance,
        boolean isLending,
        boolean isActive
) {
}
