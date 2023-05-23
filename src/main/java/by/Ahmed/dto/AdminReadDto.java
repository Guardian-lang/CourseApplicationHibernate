package by.Ahmed.dto;

import by.Ahmed.entity.AdminRule;
import by.Ahmed.entity.Gender;

import java.time.LocalDate;

public record AdminReadDto (Long id,
                           String firstName,
                           String lastName,
                           Gender gender,
                           LocalDate birthDate,
                           AdminRule adminRule) {
}
