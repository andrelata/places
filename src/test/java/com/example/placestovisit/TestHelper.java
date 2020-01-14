package com.example.placestovisit;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.model.PlaceDTO;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.mock.web.MockMultipartFile;

public final class TestHelper {

    public static PlaceDTO getValidPlaceDTO(final String description) {
        final MockMultipartFile multipartImage = new MockMultipartFile("file", "test.jpg",
                "image/jpeg", "test image content".getBytes());
        return new PlaceDTO(description, multipartImage);
    }

    public static Place getValidPlace(final String description) {
        final Binary mockImage =  new Binary(BsonBinarySubType.BINARY, new byte[3]);
        return new Place(description, mockImage);
    }
}
