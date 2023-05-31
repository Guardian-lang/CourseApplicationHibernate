package by.ahmed.validator.authorValidator;

import by.ahmed.dao.AuthorDao;
import by.ahmed.dto.AuthorDto;
import by.ahmed.validator.Error;
import by.ahmed.validator.ValidationResult;
import by.ahmed.validator.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewAuthorValidator implements Validator<AuthorDto> {

    public static final NewAuthorValidator INSTANCE = new NewAuthorValidator();
    private static final AuthorAttributesValidator userValidator = AuthorAttributesValidator.getInstance();
    private static final AuthorDao authorDao = AuthorDao.getInstance();

    public static NewAuthorValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(AuthorDto object) throws ValidationException {
        var validationResult = new ValidationResult();

        List<String> invalidDataMessages = new ArrayList<>();

        if (authorDao.findByEmail(object.getEmail()) == null) {
            invalidDataMessages.add("email");
        }
        if (!invalidDataMessages.isEmpty()) {
            String errorMessage = "Author with such data already exists";
            String errors = "(" + String.join(", ", invalidDataMessages) + ")";

            validationResult.add(Error.of("invalid.data",
                    errorMessage + errors));
            return validationResult;
        }


        if (object.getEmail().isEmpty() ||
                object.getEmail().length() > 32) {
            validationResult.add(Error.of("invalid.username",
                    "Username is invalid"));
        }
        if (object.getEmail().isEmpty() ||
                !userValidator.validateEmail(object.getEmail())) {
            validationResult.add(Error.of("invalid.email",
                    "Email is invalid"));
        }

        if (object.getPassword().isEmpty() ||
                !userValidator.validatePassword(object.getPassword())) {
            validationResult.add(Error.of("invalid.password",
                    "Password is invalid. It must have one lowercase and one uppercase letter, one number and contain at least 6 characters"));
        }

        return validationResult;
    }
}
