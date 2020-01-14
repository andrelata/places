package com.example.placestovisit.validator;

import com.example.placestovisit.model.PlaceDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;

import static com.example.placestovisit.validator.StringValidationHelpers.lessThan;
import static com.example.placestovisit.validator.StringValidationHelpers.notNull;

public class PlaceParamValidator {

    public void validate(final PlaceDTO placeDTO) throws ValidationException {
        notNull.and(lessThan(300)).test(placeDTO.getDescription()).throwIfInvalid("description");
        notEmptyFile().test(placeDTO.getFile()).throwIfInvalid("image");
    }

    private SimpleValidation<MultipartFile> notEmptyFile() {
        return SimpleValidation.from(multipartFile -> multipartFile != null && !multipartFile.isEmpty(),
                "must not be null.");
    }
}
