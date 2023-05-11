package by.Ahmed.dto;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleDto {
    Long id;
    Long themeId;
    Long authorId;
    String title;
    Date date;
    String text;
}
