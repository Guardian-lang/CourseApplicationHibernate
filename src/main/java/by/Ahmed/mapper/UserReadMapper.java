package by.Ahmed.mapper;

import by.Ahmed.dto.UserReadDto;
import by.Ahmed.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto mapFrom(User object) {
        return new UserReadDto(object.getId(),
                object.getIp()
        );
    }
}
