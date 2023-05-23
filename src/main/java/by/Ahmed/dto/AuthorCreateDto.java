package by.Ahmed.dto;

import by.Ahmed.entity.CheckStatus;
import by.Ahmed.entity.Gender;

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