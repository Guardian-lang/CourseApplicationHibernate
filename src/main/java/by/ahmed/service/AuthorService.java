package by.ahmed.service;

import by.ahmed.dao.AuthorDao;
import by.ahmed.dao.AuthorRepository;
import by.ahmed.dto.AuthorCreateDto;
import by.ahmed.dto.AuthorReadDto;
import by.ahmed.mapper.AuthorCreateMapper;
import by.ahmed.mapper.AuthorReadMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorCreateMapper authorCreateMapper;
    private final AuthorReadMapper authorReadMapper;
    private final AuthorDao authorDao;

    public Optional<AuthorReadDto> findAuthorById(Long id) {
        return authorRepository.findById(id).map(authorReadMapper::mapFrom);
    }

    public Optional<AuthorReadDto> login(String email, String password) {
        return authorDao.findByEmailAndPassword(email, password).map(authorReadMapper::mapFrom);
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

