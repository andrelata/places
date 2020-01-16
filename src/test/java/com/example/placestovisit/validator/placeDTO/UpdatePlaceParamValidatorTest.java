package com.example.placestovisit.validator.placeDTO;

import com.example.placestovisit.model.PlaceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import javax.validation.ValidationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpdatePlaceParamValidatorTest {

    private UpdatePlaceParamValidator validator = new UpdatePlaceParamValidator();

    @Test
    public void validate_placeWithDescriptionAndImage_isOk(){
        final MockMultipartFile multipartImage = new MockMultipartFile("file", "test.jpg",
                "image/jpeg", "test image content".getBytes());
        final PlaceDTO placeDTO = new PlaceDTO("alemania", multipartImage);
        validator.validate(placeDTO);
    }

    @Test
    public void validate_placeWithoutDescription_isInvalid() {
        final MockMultipartFile multipartImage = new MockMultipartFile("file", "test.jpg",
                "image/jpeg", "test image content".getBytes());
        final PlaceDTO placeDTO = new PlaceDTO("", multipartImage);
        Exception exception = assertThrows(ValidationException.class, () -> {
            validator.validate(placeDTO);
        });
        assertThat(exception.getMessage(), is("description : must not be null."));
    }

    @Test
    public void validate_placeWithDescriptionGreaterThan300_isInvalid() {
        final MockMultipartFile multipartImage = new MockMultipartFile("file", "test.jpg",
                "image/jpeg", "test image content".getBytes());
        final String description = "New Zealand's South Island brims with majestic landscapes at every turn, " +
                "from dramatic mountains to fjords to glaciers. Here, you can explore Fiordland National Park, " +
                "a UNESCO World Heritage Area, or gaze at the starry skies at Mount John Observatory. " +
                "You can also indulge your inner daredevil in Queenstown, explore two of the most accessible glaciers " +
                "in the world on the west coast or sample delicious food and wine in Marlborough.";
        final PlaceDTO placeDTO = new PlaceDTO(description, multipartImage);
        Exception exception = assertThrows(ValidationException.class, () -> {
            validator.validate(placeDTO);
        });
        assertThat(exception.getMessage(), is("description : must have less than 300 chars."));
    }
}