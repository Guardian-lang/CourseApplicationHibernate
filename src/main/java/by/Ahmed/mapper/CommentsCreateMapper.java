package by.Ahmed.mapper;

import by.Ahmed.dao.UserRepository;
import by.Ahmed.dto.CommentsCreateDto;
import by.Ahmed.entity.Comments;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentsCreateMapper implements Mapper<CommentsCreateDto, Comments>{

    private final UserRepository userRepository;
    @Override
    public Comments mapFrom(CommentsCreateDto object) {
        return Comments.builder()
                .user(userRepository.findById(object.userId())
                        .orElseThrow(IllegalArgumentException::new))
                .text(object.text())
                .build();
    }
}
