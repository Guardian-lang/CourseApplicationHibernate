package by.ahmed.mapper;

import by.ahmed.dto.CommentsReadDto;
import by.ahmed.entity.Comments;
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
