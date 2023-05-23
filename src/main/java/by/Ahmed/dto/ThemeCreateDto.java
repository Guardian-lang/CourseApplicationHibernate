package by.Ahmed.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record ThemeCreateDto(
        @Valid
        @NotNull
        Long id,
        String name,
        String description) {
}
