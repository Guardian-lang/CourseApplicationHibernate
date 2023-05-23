package by.Ahmed.mapper;

import by.Ahmed.dto.AdminCreateDto;
import by.Ahmed.entity.Admin;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminCreateMapper implements Mapper<AdminCreateDto, Admin>{

    @Override
    public Admin mapFrom(AdminCreateDto object) {
        return Admin.builder()
                .firstName(object.firstName())
                .lastName(object.lastName())
                .gender(object.gender())
                .birthDate(object.birthDate())
                .adminRule(object.adminRule())
                .build();
    }
}
