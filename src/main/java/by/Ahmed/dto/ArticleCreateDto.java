package by.Ahmed.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public record ArticleCreateDto(
        @Valid
        @NotNull
        Long id,
        Long themeId,
        Long authorId,
        String title,
        Date date,
        String text) {
}
