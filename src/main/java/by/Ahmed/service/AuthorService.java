package by.Ahmed.service;

import by.Ahmed.dao.AuthorRepository;
import by.Ahmed.dto.AuthorCreateDto;
import by.Ahmed.dto.AuthorReadDto;
import by.Ahmed.mapper.AuthorCreateMapper;
import by.Ahmed.mapper.AuthorReadMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorCreateMapper authorCreateMapper;
    private final AuthorReadMapper authorReadMapper;

    public Optional<AuthorReadDto> findAuthorById(Long id) {
        return authorRepository.findById(id).map(authorReadMapper::mapFrom);
    }

    public Long create(AuthorCreateDto authorDto) {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        var validator = validationFactory.getValidator();
        var validationResult = validator.validate(authorDto);
        if(!validationResult.isEmpty())
            throw new ConstraintViolationException(validationResult);

        var authorEntity = authorCreateMapper.mapFrom(authorDto);
        return authorRepository.save(authorEntity).getId();
    }

    public boolean delete(Long id) {
        var maybeUser = authorRepository.findById(id);
        maybeUser.ifPresent(user -> authorRepository.delete(id));
        return maybeUser.isPresent();
    }
}

