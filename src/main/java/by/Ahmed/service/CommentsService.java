package by.Ahmed.service;

import by.Ahmed.dao.CommentsRepository;
import by.Ahmed.dto.CommentsCreateDto;
import by.Ahmed.dto.CommentsReadDto;
import by.Ahmed.mapper.CommentsCreateMapper;
import by.Ahmed.mapper.CommentsReadMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Optional;

@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final CommentsCreateMapper commentsCreateMapper;
    private final CommentsReadMapper commentsReadMapper;

    public Optional<CommentsReadDto> findCommentsById(Long id) {
        return commentsRepository.findById(id).map(commentsReadMapper::mapFrom);
    }

    public Long create(CommentsCreateDto articleDto) {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        var validator = validationFactory.getValidator();
        var validationResult = validator.validate(articleDto);
        if(!validationResult.isEmpty())
            throw new ConstraintViolationException(validationResult);

        var commentsEntity = commentsCreateMapper.mapFrom(articleDto);
        return commentsRepository.save(commentsEntity).getId();
    }

    public boolean delete(Long id) {
        var maybeUser = commentsRepository.findById(id);
        maybeUser.ifPresent(user -> commentsRepository.delete(id));
        return maybeUser.isPresent();
    }
}
