package com.example.placestovisit.validator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class StringValidationHelpersTest {

    @Test
    public void notNull_StringIsEmpty_isNotValidWithMessage() {
        final ValidationResult validationResult = StringValidationHelpers.notNull.test(null);
        assertThat(validationResult.isValid(), is(false));
        assertThat(validationResult.getMessage(), is("must not be null."));
    }

    @Test
    public void notNull_StringNotEmpty_isOk() {
        final ValidationResult validationResult = StringValidationHelpers.notNull.test("hola");
       assertThat(validationResult.isValid(), is(true)) ;
    }

    @Test
    public void lessThan_StringLessThan5_isOk() {
        final ValidationResult validationResult = StringValidationHelpers.lessThan(5).test("hola");
        assertThat(validationResult.isValid(), is(true));
    }

    @Test
    public void lessThan_StringGreaterThan5_isNotValidWithMessage() {
        final ValidationResult validationResult = StringValidationHelpers.lessThan(5).test("hola hola");
        assertThat(validationResult.isValid(), is(false));
        assertThat(validationResult.getMessage(), is("must have less than 5 chars."));
    }

}