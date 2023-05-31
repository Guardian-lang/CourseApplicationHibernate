package by.ahmed.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ThemeDto {
    private Long id;
    private String name;
    private String description;
}
