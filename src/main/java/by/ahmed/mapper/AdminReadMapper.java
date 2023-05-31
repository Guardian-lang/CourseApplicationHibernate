package by.ahmed.mapper;

import by.ahmed.dto.AdminReadDto;
import by.ahmed.entity.Admin;
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