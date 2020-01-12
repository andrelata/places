package com.example.placestovisit.validator;

import org.springframework.util.StringUtils;

import static java.lang.String.format;

final class StringValidationHelpers {

    static SimpleValidation<String> notNull = SimpleValidation.from(s -> !StringUtils.isEmpty(s), "must not be null.");

    static SimpleValidation<String> lessThan(int size) {
        return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
    }
}
