package by.ahmed.mapper;

import by.ahmed.dto.UserReadDto;
import by.ahmed.entity.User;
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
