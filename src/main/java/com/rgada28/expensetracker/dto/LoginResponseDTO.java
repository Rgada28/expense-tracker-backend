package com.rgada28.expensetracker.dto;

import com.rgada28.expensetracker.model.AppUser;

public record LoginResponseDTO(String jwt,String username,String email) {
}
