package com.example.placestovisit.validator;

import org.junit.jupiter.api.Test;

class PlaceParamValidatorTest {

    private PlaceParamValidator validator = new PlaceParamValidator();

    @Test
    public void validate_placeWithDescriptionAndImage_isOk(){

    }

    @Test
    public void validate_placeWithoutDescription_isInvalid() {

    }

    @Test
    public void validate_placeWithDecriptionGreaterThan300_isInvalid() {

    }

    @Test
    public void validate_placeWithoutImage_isInvalid() {

    }

}