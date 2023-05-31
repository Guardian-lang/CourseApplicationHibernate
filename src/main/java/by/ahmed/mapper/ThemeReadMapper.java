package by.ahmed.mapper;

import by.ahmed.dto.ThemeReadDto;
import by.ahmed.entity.Theme;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThemeReadMapper implements Mapper<Theme, ThemeReadDto> {

    @Override
    public ThemeReadDto mapFrom(Theme object) {
        return new ThemeReadDto(object.getId(),
                object.getName(),
                object.getDescription()
        );
    }
}
