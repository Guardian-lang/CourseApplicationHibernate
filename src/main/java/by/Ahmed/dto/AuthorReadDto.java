package by.Ahmed.dto;

import by.Ahmed.entity.CheckStatus;
import by.Ahmed.entity.Gender;

import java.sql.Date;

public record AuthorReadDto (Long id,
                            String firstName,
                            String lastName,
                            Gender gender,
                            Date birthDate,
                            String occupation,
                            String jobTitle,
                            CheckStatus checkStatus,
                            String about,
                            String email,
                            String password) {
}
