package com.cornerbox.api.v1.dto;

import jakarta.validation.constraints.*;

public record GymCreateRequest (
    @NotBlank(message = "Gym name is required")
    @Size (max = 100, message = "Gym name must not exceed 100 characters")
    String name,

    @NotBlank(message = "Gym address is required")
    @Size (max = 250, message = "Gym address must not exceed 250 characters")
    String address,

    @NotBlank(message = "Gym phone number is required")
    @Size (max = 20, message = "Gym phone number must not exceed 20 characters")
    String phoneNumber,

    @NotBlank(message = "Gym email is required")
    @Email(message = "Gym email must be a valid email address")
    String email
 ) {}