package by.Ahmed.mapper;

import by.Ahmed.dto.AdminReadDto;
import by.Ahmed.dto.AuthorReadDto;
import by.Ahmed.entity.Admin;
import by.Ahmed.entity.Author;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorReadMapper implements Mapper<Author, AuthorReadDto> {

    @Override
    public AuthorReadDto mapFrom(Author object) {
        return new AuthorReadDto(object.getId(),
                object.getFirstName(),
                object.getLastName(),
                object.getGender(),
                object.getBirthDate(),
                object.getOccupation(),
                object.getJobTitle(),
                object.getCheckStatus(),
                object.getAbout()
        );
    }
}
