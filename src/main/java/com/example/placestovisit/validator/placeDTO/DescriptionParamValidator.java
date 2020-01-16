package com.example.placestovisit.validator.placeDTO;

import com.example.placestovisit.model.PlaceDTO;

import static com.example.placestovisit.validator.StringValidationHelpers.lessThan;
import static com.example.placestovisit.validator.StringValidationHelpers.notNull;

public class DescriptionParamValidator {

    public void validate(PlaceDTO placeDTO) {
        notNull.and(lessThan(300)).test(placeDTO.getDescription()).throwIfInvalid("description");
    }

}
