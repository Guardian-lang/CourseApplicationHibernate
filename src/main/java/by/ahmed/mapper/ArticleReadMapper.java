package by.ahmed.mapper;

import by.ahmed.dto.ArticleReadDto;
import by.ahmed.entity.Article;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleReadMapper implements Mapper<Article, ArticleReadDto> {

    private final ThemeReadMapper themeReadMapper;
    private final AuthorReadMapper authorReadMapper;

    @Override
    public ArticleReadDto mapFrom(Article object) {
        return new ArticleReadDto(object.getId(),
                themeReadMapper.mapFrom(object.getTheme().getId()),
                authorReadMapper.mapFrom(object.getAuthor().getId()),
                object.getTitle(),
                object.getDate(),
                object.getText()
                );
    }
}
