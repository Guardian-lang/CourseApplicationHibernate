package by.ahmed.mapper;

import by.ahmed.dto.UserCreateDto;
import by.ahmed.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCreateMapper implements Mapper<UserCreateDto, User>{

    @Override
    public User mapFrom(UserCreateDto object) {
        return User.builder()
                .ip(object.ip())
                .build();
    }
}
