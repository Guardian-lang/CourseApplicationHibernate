package by.ahmed.dto;

import by.ahmed.entity.AdminRule;
import by.ahmed.entity.Gender;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private AdminRule adminRule;
}
