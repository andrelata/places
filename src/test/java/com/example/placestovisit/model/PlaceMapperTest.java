package com.example.placestovisit.model;

import com.example.placestovisit.TestHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

class PlaceMapperTest {

    @Test
    public void toPlace_validDTO_isOk() throws IOException {
        final Place place = PlaceMapper.toPlace(TestHelper.getValidPlaceDTO("brasil"));
        assertThat(place.getDescription(), is("brasil"));
        assertThat(place.getImage(), notNullValue());
    }

    @Test
    public void toPlaceDTO_validPlace_isOk() {
        final PlaceDTO placeDTO = PlaceMapper.toPlaceDTO(TestHelper.getValidPlace("españa"));
        assertThat(placeDTO.getDescription(), is("españa"));
        assertThat(placeDTO.getImage(), notNullValue());
    }

    @Test
    public void updatePlace_newImageAndDescription_isOk() throws IOException {
        final PlaceDTO placeDTO = TestHelper.getValidPlaceDTO("españa");
        final Place place = TestHelper.getValidPlace("brasil");
        Place newPlace = PlaceMapper.updatePlace(place, placeDTO);
        assertThat(newPlace.getDescription(), is(placeDTO.getDescription()));
        assertThat(newPlace.getImage().getData(), is(placeDTO.getFile().getBytes()));
    }

}