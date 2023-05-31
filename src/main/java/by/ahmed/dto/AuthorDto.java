package by.ahmed.dto;

import by.ahmed.entity.CheckStatus;
import by.ahmed.entity.Gender;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class AuthorDto {
    Long id;
    String firstName;
    String lastName;
    Gender gender;
    Date birthDate;
    String occupation;
    String jobTitle;
    CheckStatus checkStatus;
    String about;
    String email;
    String password;
}


