package by.ahmed.service;

import by.ahmed.dao.ThemeRepository;
import by.ahmed.dto.ThemeCreateDto;
import by.ahmed.dto.ThemeReadDto;
import by.ahmed.mapper.ThemeCreateMapper;
import by.ahmed.mapper.ThemeReadMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Optional;

@RequiredArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;
    private final ThemeCreateMapper themeCreateMapper;
    private final ThemeReadMapper themeReadMapper;

    public Optional<ThemeReadDto> findThemeById(Long id) {
        return themeRepository.findById(id).map(themeReadMapper::mapFrom);
    }

    public Long create(ThemeCreateDto themeDto) {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        var validator = validationFactory.getValidator();
        var validationResult = validator.validate(themeDto);
        if(!validationResult.isEmpty())
            throw new ConstraintViolationException(validationResult);

        var themeEntity = themeReadMapper.mapFrom(themeDto);
        return themeRepository.save(themeEntity).getId();
    }

    public boolean delete(Long id) {
        var maybeUser = themeRepository.findById(id);
        maybeUser.ifPresent(user -> themeRepository.delete(id));
        return maybeUser.isPresent();
    }
}

