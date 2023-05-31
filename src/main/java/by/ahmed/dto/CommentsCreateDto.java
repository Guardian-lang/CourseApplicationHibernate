package by.ahmed.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record  CommentsCreateDto(
        @Valid
        @NotNull
        Long id,
        Long userId,
        String text) {
}
