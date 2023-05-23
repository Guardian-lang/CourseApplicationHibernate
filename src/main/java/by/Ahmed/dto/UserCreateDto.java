package by.Ahmed.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record UserCreateDto(
        @Valid
        @NotNull
        Long id,
        String ip) {
}

