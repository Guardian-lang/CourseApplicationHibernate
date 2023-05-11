package by.Ahmed.dto;

import by.Ahmed.entity.AdminRule;
import by.Ahmed.entity.Gender;
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
