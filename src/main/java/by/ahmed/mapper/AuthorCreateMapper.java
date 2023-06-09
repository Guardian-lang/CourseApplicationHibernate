package by.ahmed.mapper;

import by.ahmed.dto.AuthorCreateDto;
import by.ahmed.entity.Author;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthorCreateMapper implements Mapper<AuthorCreateDto, Author>{

    @Override
    public Author mapFrom(AuthorCreateDto object) {
        return Author.builder()
                .firstName(object.firstName())
                .lastName(object.lastName())
                .gender(object.gender())
                .birthDate(object.birthDate())
                .occupation(object.occupation())
                .jobTitle(object.jobTitle())
                .checkStatus(object.checkStatus())
                .about(object.about())
                .build();
    }
}

