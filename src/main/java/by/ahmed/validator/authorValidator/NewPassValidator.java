package by.ahmed.validator.authorValidator;

import by.ahmed.validator.Error;
import by.ahmed.validator.ValidationResult;
import by.ahmed.validator.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewPassValidator implements Validator<String> {
    private static final NewPassValidator INSTANCE = new NewPassValidator();
    private static final AuthorAttributesValidator userValidator = AuthorAttributesValidator.getInstance();
    public static NewPassValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(String newPassword) {
        var validationResult = new ValidationResult();
        if (newPassword.isEmpty() ||
                !userValidator.validatePassword(newPassword)) {
            validationResult.add(Error.of("invalid.password",
                    "Password is invalid. It must have one lowercase and one uppercase letter, one number and contain at least 6 characters"));
        }
        return validationResult;
    }
}
