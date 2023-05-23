package by.Ahmed.mapper;

import by.Ahmed.dto.UserCreateDto;
import by.Ahmed.entity.User;
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
