package by.ahmed.mapper;

import by.ahmed.dto.ThemeCreateDto;
import by.ahmed.entity.Theme;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThemeCreateMapper implements Mapper<ThemeCreateDto, Theme>{

    @Override
    public Theme mapFrom(ThemeCreateDto object) {
        return Theme.builder()
                .name(object.name())
                .description(object.description())
                .build();
    }
}
