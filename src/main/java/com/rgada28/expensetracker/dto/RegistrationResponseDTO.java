package com.rgada28.expensetracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistrationResponseDTO(String username, String email) {
}
