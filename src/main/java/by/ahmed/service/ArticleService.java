package by.ahmed.service;

import by.ahmed.dao.ArticleRepository;
import by.ahmed.dto.ArticleCreateDto;
import by.ahmed.dto.ArticleReadDto;
import by.ahmed.mapper.ArticleCreateMapper;
import by.ahmed.mapper.ArticleReadMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Optional;

@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleCreateMapper articleCreateMapper;
    private final ArticleReadMapper articleReadMapper;

    public Optional<ArticleReadDto> findArticleById(Long id) {
        return articleRepository.findById(id).map(articleReadMapper::mapFrom);
    }

    public Long create(ArticleCreateDto articleDto) {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        var validator = validationFactory.getValidator();
        var validationResult = validator.validate(articleDto);
        if(!validationResult.isEmpty())
            throw new ConstraintViolationException(validationResult);

        var articleEntity = articleCreateMapper.mapFrom(articleDto);
        return articleRepository.save(articleEntity).getId();
    }

    public boolean delete(Long id) {
        var maybeUser = articleRepository.findById(id);
        maybeUser.ifPresent(user -> articleRepository.delete(id));
        return maybeUser.isPresent();
    }
}
