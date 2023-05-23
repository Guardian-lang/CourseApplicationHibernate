package by.Ahmed.dto;

import java.time.LocalDate;

public record ArticleReadDto (Long id,
                              Long themeId,
                              Long authorId,
                              String title,
                              LocalDate date,
                              String text) {
}
