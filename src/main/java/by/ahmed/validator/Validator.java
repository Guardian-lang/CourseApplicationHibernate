package by.ahmed.validator;

public interface Validator<T> {
    ValidationResult isValid(T object);
}
