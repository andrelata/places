package com.example.placestovisit.validator.placeDTO;

import com.example.placestovisit.model.PlaceDTO;

import javax.validation.ValidationException;

public class UpdatePlaceParamValidator {

    private DescriptionParamValidator descriptionParamValidator;

    public UpdatePlaceParamValidator() {
        this.descriptionParamValidator = new DescriptionParamValidator();
    }

    public void validate(final PlaceDTO placeDTO) throws ValidationException {
        descriptionParamValidator.validate(placeDTO);
    }
}
