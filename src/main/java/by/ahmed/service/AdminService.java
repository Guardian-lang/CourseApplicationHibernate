package by.ahmed.service;

import by.ahmed.dao.AdminRepository;
import by.ahmed.dto.AdminCreateDto;
import by.ahmed.dto.AdminReadDto;
import by.ahmed.mapper.AdminCreateMapper;
import by.ahmed.mapper.AdminReadMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import java.util.Optional;

@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminCreateMapper adminCreateMapper;
    private final AdminReadMapper adminReadMapper;

    public Optional<AdminReadDto> findAdminById(Long id) {
        return adminRepository.findById(id).map(adminReadMapper::mapFrom);
    }

    public Long create(AdminCreateDto adminDto) {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        var validator = validationFactory.getValidator();
        var validationResult = validator.validate(adminDto);
        if(!validationResult.isEmpty())
            throw new ConstraintViolationException(validationResult);

        var adminEntity = adminCreateMapper.mapFrom(adminDto);
        return adminRepository.save(adminEntity).getId();
    }

    public boolean delete(Long id) {
        var maybeUser = adminRepository.findById(id);
        maybeUser.ifPresent(user -> adminRepository.delete(id));
        return maybeUser.isPresent();
    }
}
