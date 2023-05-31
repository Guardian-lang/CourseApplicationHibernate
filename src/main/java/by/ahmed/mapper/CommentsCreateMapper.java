package by.ahmed.mapper;

import by.ahmed.dao.UserRepository;
import by.ahmed.dto.CommentsCreateDto;
import by.ahmed.entity.Comments;
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
