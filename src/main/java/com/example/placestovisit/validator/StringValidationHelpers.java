package com.example.placestovisit.validator;

import java.util.Objects;

import static java.lang.String.format;

final class StringValidationHelpers {

    static SimpleValidation<String> notNull = SimpleValidation.from(Objects::nonNull, "must not be null.");

    static SimpleValidation<String> lessThan(int size) {
        return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
    }
}
