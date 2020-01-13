package com.example.placestovisit.model;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import java.io.IOException;
import java.util.Base64;

public final class PlaceMapper {

    public static Place toPlace(final PlaceDTO placeDTO) throws IOException {
        final Binary imagePlace = new Binary(BsonBinarySubType.BINARY, placeDTO.getFile().getBytes());
        return new Place(placeDTO.getDescription(), imagePlace);
    }

    public static PlaceDTO toPlaceDTO(final Place place) {
        String imagePlaceDTO = null;
        if (place.getImage() != null) {
            imagePlaceDTO = Base64.getEncoder().encodeToString(place.getImage().getData());
        }
        return new PlaceDTO(place.getId(), place.getDescription(), imagePlaceDTO);
    }

    public static Place updatePlace(final Place place, final PlaceDTO placeDTO) throws IOException {
        final Binary imagePlace = new Binary(BsonBinarySubType.BINARY, placeDTO.getFile().getBytes());
        if (!place.getImage().equals(imagePlace)) {
            place.setImage(imagePlace);
        }
        if (!place.getDescription().equalsIgnoreCase(place.getDescription())) {
            place.setDescription(placeDTO.getDescription());
        }
        return place;
    }
}
