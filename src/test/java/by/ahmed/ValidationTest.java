package by.ahmed;

import by.ahmed.dto.AuthorDto;
import by.ahmed.entity.CheckStatus;
import by.ahmed.entity.Gender;
import by.ahmed.validator.authorValidator.AuthorAttributesValidator;
import by.ahmed.validator.authorValidator.NewAuthorValidator;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationTest {
    private static final AuthorAttributesValidator validator = AuthorAttributesValidator.getInstance();

    @Test
    public void isValid() {
        AuthorDto newAuthor = AuthorDto.builder()
                .firstName("Георгий")
                .lastName("Ахметзянов")
                .gender(Gender.MALE)
                .occupation("Программист")
                .jobTitle("Senior Java Developer")
                .checkStatus(CheckStatus.CHECKED)
                .email("ahmedtretiy@gmail.com")
                .password("@dsijgjlk12345")
                .build();
        System.out.println(NewAuthorValidator.getInstance().isValid(newAuthor).getErrors());
        Assert.assertTrue(NewAuthorValidator.getInstance().isValid(newAuthor).isValid());
    }

    @Test
    public void validateEmail() {
        assertTrue(validator.validateEmail("ahmedtretiy@gmail.com"));
    }

    @Test
    public void validateWrongEmail() {
        assertFalse(validator.validateEmail("Ahmedtretiygmailcom"));
    }

    @Test
    public void validatePassword() {
        assertTrue(validator.validatePassword("@dsijgjlk12345"));
    }

    @Test
    public void validateWrongPassword() {
        assertFalse(validator.validatePassword("dsijgjlk12345"));
    }
}
