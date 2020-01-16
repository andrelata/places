package com.example.placestovisit.validator;

import org.springframework.util.StringUtils;

import static java.lang.String.format;

public final class StringValidationHelpers {

    public static SimpleValidation<String> notNull = SimpleValidation.from(s -> !StringUtils.isEmpty(s), "must not be null.");

    public static SimpleValidation<String> lessThan(int size) {
        return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
    }
}
