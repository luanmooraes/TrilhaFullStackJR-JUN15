package com.manager.api.domain.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RequestProjectDTO(
        @NotNull(message = "Title is required")
        String title,
        @NotBlank(message = "Description is required")
        String description,
        @NotNull(message = "CreatedAt is required")
        LocalDate createdAt
) {
}
