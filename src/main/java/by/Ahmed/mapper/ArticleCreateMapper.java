package by.Ahmed.mapper;

import by.Ahmed.dao.AuthorRepository;
import by.Ahmed.dao.ThemeRepository;
import by.Ahmed.dto.ArticleCreateDto;
import by.Ahmed.entity.Article;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleCreateMapper implements Mapper<ArticleCreateDto, Article>{

    private final ThemeRepository themeRepository;
    private final AuthorRepository authorRepository;
    @Override
    public Article mapFrom(ArticleCreateDto object) {
        return Article.builder()
                .theme(themeRepository.findById(object.themeId())
                        .orElseThrow(IllegalArgumentException::new))
                .author(authorRepository.findById(object.authorId())
                        .orElseThrow(IllegalArgumentException::new))
                .title(object.title())
                .date(object.date())
                .text(object.text())
                .build();
    }
}
