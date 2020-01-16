package com.example.placestovisit.validator.placeDTO;

import com.example.placestovisit.model.PlaceDTO;
import com.example.placestovisit.validator.SimpleValidation;
import org.springframework.web.multipart.MultipartFile;

public class ImageParamValidator {

    public void validate(PlaceDTO placeDTO) {
        notEmptyFile().test(placeDTO.getFile()).throwIfInvalid("image");
    }

    private SimpleValidation<MultipartFile> notEmptyFile() {
        return SimpleValidation.from(multipartFile -> multipartFile != null && !multipartFile.isEmpty(),
                "must not be null.");
    }
}
