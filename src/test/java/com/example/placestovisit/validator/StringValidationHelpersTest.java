package com.example.placestovisit.validator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class StringValidationHelpersTest {

    @Test
    public void notNull_StringIsEmpty_isFalseWithMessage() {
        final ValidationResult validationResult = StringValidationHelpers.notNull.test(null);
        assertThat(validationResult.isValid(), is(false));
        assertThat(validationResult.getMessage(), is("must not be null."));
    }

    @Test
    public void notNull_StringNotEmpty_isOk() {
        final ValidationResult validationResult = StringValidationHelpers.notNull.test("hola");
       assertThat(validationResult.isValid(), is(true)) ;
    }

    //TODO agregar test lessThan

}