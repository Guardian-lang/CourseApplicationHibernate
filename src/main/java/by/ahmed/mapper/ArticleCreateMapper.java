package by.ahmed.mapper;

import by.ahmed.dao.AuthorRepository;
import by.ahmed.dao.ThemeRepository;
import by.ahmed.dto.ArticleCreateDto;
import by.ahmed.entity.Article;
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
