package by.Ahmed.mapper;

import by.Ahmed.dto.ArticleReadDto;
import by.Ahmed.dto.CommentsReadDto;
import by.Ahmed.entity.Article;
import by.Ahmed.entity.Comments;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentsReadMapper implements Mapper<Comments, CommentsReadDto> {

    private final UserReadMapper userReadMapper;

    @Override
    public CommentsReadDto mapFrom(Comments object) {
        return new CommentsReadDto(object.getId(),
                userReadMapper.mapFrom(object.getUser().getId()),
                object.getText()
        );
    }
}
