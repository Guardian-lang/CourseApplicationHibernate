package by.ahmed.validator.authorValidator;

import by.ahmed.dao.AuthorDao;
import by.ahmed.dto.AuthorDto;
import by.ahmed.validator.ValidationResult;
import by.ahmed.validator.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogInValidator implements Validator<AuthorDto> {
    private static final LogInValidator INSTANCE = new LogInValidator();
    private static final AuthorDao authorDao = AuthorDao.getInstance();

    public static LogInValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(AuthorDto object) {
        var validationResult = new ValidationResult();
        if (authorDao.findByEmail(object.getEmail()) != null) {
            validationResult.add(Error.of("invalid.username",
                    "Such user does not exist"));
        }
        return validationResult;
    }

    public ValidationResult isValidPassword(Optional<AuthorDto> optionalAuthorDto, ValidationResult validationResult) {
        if (optionalAuthorDto.isEmpty()) {
            validationResult.add(Error.of("invalid.password", "Password is invalid"));
        }
        return validationResult;
    }
}
