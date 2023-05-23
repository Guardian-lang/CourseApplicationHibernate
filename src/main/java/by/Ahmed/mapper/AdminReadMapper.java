package by.Ahmed.mapper;

import by.Ahmed.dto.AdminReadDto;
import by.Ahmed.entity.Admin;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminReadMapper implements Mapper<Admin, AdminReadDto> {

    @Override
    public AdminReadDto mapFrom(Admin object) {
        return new AdminReadDto(object.getId(),
                object.getFirstName(),
                object.getLastName(),
                object.getGender(),
                object.getBirthDate(),
                object.getAdminRule()
        );
    }
}