package by.Ahmed.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateThemeDto {
    private String id;
    private String name;
    private String description;
}
