package com.rgada28.expensetracker.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
        @NotNull(message = "Username cannot be null")
        String username,

        @Size(message = "Password should contain at least 8 characters " ,min = 8)
        String password
) {
}
