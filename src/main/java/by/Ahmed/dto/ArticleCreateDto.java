package by.Ahmed.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ArticleCreateDto(
        @Valid
        @NotNull
        Long id,
        Long themeId,
        Long authorId,
        String title,
        LocalDate date,
        String text) {
}
