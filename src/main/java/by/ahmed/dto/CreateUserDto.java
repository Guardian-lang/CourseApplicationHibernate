package by.ahmed.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserDto {
    private String id;
    private String userIp;
}
