package com.manager.api.domain.project;

import java.time.LocalDate;

public record ResponseProjectDTO(
        String id,
        String name,
        String description,
        LocalDate createdAt
) {
}
