package by.Ahmed.mapper;

import by.Ahmed.dto.ThemeCreateDto;
import by.Ahmed.entity.Theme;
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
