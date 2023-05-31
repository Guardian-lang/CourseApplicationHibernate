package by.ahmed.dto;

import by.ahmed.entity.AdminRule;
import by.ahmed.entity.Gender;

import java.time.LocalDate;

public record AdminReadDto (Long id,
                           String firstName,
                           String lastName,
                           Gender gender,
                           LocalDate birthDate,
                           AdminRule adminRule) {
}
