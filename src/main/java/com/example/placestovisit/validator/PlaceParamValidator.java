package com.example.placestovisit.validator;

import com.example.placestovisit.model.PlaceDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

import static com.example.placestovisit.validator.StringValidationHelpers.lessThan;
import static com.example.placestovisit.validator.StringValidationHelpers.notNull;

public class PlaceParamValidator {

    public void validate(final PlaceDTO placeDTO) {
        notNull.and(lessThan(300)).test(placeDTO.getDescription()).throwIfInvalid("description");
        notEmptyFile().test(placeDTO.getFile()).throwIfInvalid("image");
    }

    private SimpleValidation<MultipartFile> notEmptyFile() {
        return SimpleValidation.from(Objects::nonNull, "must not be null.");
    }
}
