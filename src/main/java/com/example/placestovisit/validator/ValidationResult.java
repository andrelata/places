package com.example.placestovisit.validator;

import javax.validation.ValidationException;

public class ValidationResult {

    private boolean valid;
    private String message;

    private ValidationResult(final boolean valid, final String message) {
        this.valid = valid;
        this.message = message;
    }

    static ValidationResult ok() {
        return new ValidationResult(true, null);
    }

    static ValidationResult fail(String message) {
        return new ValidationResult(false, message);
    }

    public boolean isValid() {
        return valid;
    }

    public void throwIfInvalid(String fieldName) throws ValidationException {
        if(!this.valid) throw new ValidationException(fieldName + " : " + message);
    }

    public String getMessage() {
        return message;
    }
}
