package com.example.placestovisit.validator.placeDTO;

import com.example.placestovisit.model.PlaceDTO;

import javax.validation.ValidationException;

public class AddPlaceParamValidator {

    private DescriptionParamValidator descriptionParamValidator;
    private ImageParamValidator imageParamValidator;

    public AddPlaceParamValidator() {
        this.descriptionParamValidator = new DescriptionParamValidator();
        this.imageParamValidator = new ImageParamValidator();
    }

    public void validate(final PlaceDTO placeDTO) throws ValidationException {
        descriptionParamValidator.validate(placeDTO);
        imageParamValidator.validate(placeDTO);
    }

}
