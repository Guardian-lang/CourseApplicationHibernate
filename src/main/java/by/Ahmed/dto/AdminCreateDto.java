package by.Ahmed.dto;

import by.Ahmed.entity.AdminRule;
import by.Ahmed.entity.Gender;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record AdminCreateDto(
        @Valid
        @NotNull
        Long id,
        String firstName,
        String lastName,
        Gender gender,
        LocalDate birthDate,
        AdminRule adminRule) {
}
