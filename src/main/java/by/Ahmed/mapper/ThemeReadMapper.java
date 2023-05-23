package by.Ahmed.mapper;

import by.Ahmed.dto.ThemeReadDto;
import by.Ahmed.dto.UserReadDto;
import by.Ahmed.entity.Theme;
import by.Ahmed.entity.User;
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
