package by.ahmed.dto;

import by.ahmed.entity.CheckStatus;
import by.ahmed.entity.Gender;

import java.sql.Date;

public record AuthorReadDto (Long id,
                            String firstName,
                            String lastName,
                            Gender gender,
                            Date birthDate,
                            String occupation,
                            String jobTitle,
                            CheckStatus checkStatus,
                            String about) {
}
