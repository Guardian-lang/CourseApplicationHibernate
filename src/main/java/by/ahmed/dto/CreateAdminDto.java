package by.ahmed.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateAdminDto {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String adminRule;
}
