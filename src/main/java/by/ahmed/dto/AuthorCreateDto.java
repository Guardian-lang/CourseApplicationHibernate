package by.ahmed.dto;

import by.ahmed.entity.CheckStatus;
import by.ahmed.entity.Gender;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public record AuthorCreateDto(
        @Valid
        @NotNull
        Long id,
        String firstName,
        String lastName,
        Gender gender,
        Date birthDate,
        String occupation,
        String jobTitle,
        CheckStatus checkStatus,
        String about) {
}