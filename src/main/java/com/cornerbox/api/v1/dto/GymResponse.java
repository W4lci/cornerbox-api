package com.cornerbox.api.v1.dto;

import java.time.LocalDateTime;

public record GymResponse(
    Long id,
    String name,
    String address,
    String phoneNumber,
    String email,
    Integer capacity,
    LocalDateTime createdAt
) {}
