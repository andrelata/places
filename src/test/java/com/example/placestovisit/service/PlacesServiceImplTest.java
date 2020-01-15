package com.example.placestovisit.service;

import com.example.placestovisit.TestHelper;
import com.example.placestovisit.model.Place;
import com.example.placestovisit.model.PlaceDTO;
import com.example.placestovisit.repository.PlaceMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlacesServiceImplTest {

    @Autowired
    private PlacesServiceImpl placesServiceImpl;

    @Autowired
    private PlaceMongoRepository placeMongoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //Annotation before doesn't work
    public void init() {
        placeMongoRepository.deleteAll();

        placeMongoRepository.save(TestHelper.getValidPlace("Brasil"));
        placeMongoRepository.save(TestHelper.getValidPlace("Portugal"));
    }

    @Test
    public void create_addNewPlace_isOk() throws IOException {
        placeMongoRepository.deleteAll();
        assertThat(placeMongoRepository.findAll(), empty());

        placesServiceImpl.create(TestHelper.getValidPlaceDTO("España"));
        assertThat(placeMongoRepository.findAll().size(), is(1));
    }

    @Test
    public void getSortByOrder_notPlaces_isEmpty() {
        placeMongoRepository.deleteAll();
        final List<PlaceDTO> placeDTOS = placesServiceImpl.getSortByOrder();

        assertThat(placeDTOS, empty());
    }

    @Test
    public void getSortByOrder_thereAreSomePlaces_isOk() {
        init();
        final List<PlaceDTO> placeDTOS = placesServiceImpl.getSortByOrder();

        assertThat(placeDTOS.size(), is(2));
    }

    @Test
    public void remove_validId_isOk() {
        init();
        final List<PlaceDTO> places = placesServiceImpl.getSortByOrder();
        assertThat(places.size(), is(2));

        places.forEach(placeDTO -> placesServiceImpl.remove(placeDTO.getId()));

        assertThat(placesServiceImpl.getSortByOrder(), empty());
    }

    @Test
    public void remove_invalidId_throwException() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placesServiceImpl.remove("12");
        });
        assertThat(exception.getMessage(), is("Invalid place Id: 12"));
    }

    @Test
    public void getById_validId_isOk() {
        Place place = placeMongoRepository.save(TestHelper.getValidPlace("España"));
        PlaceDTO placeDTO = placesServiceImpl.getById(place.getId());
        assertThat(placeDTO.getDescription(), is("España"));
    }

    @Test
    public void getById_invalidId_throwException() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placesServiceImpl.getById("12");
        });
        assertThat(exception.getMessage(), is("Invalid place Id: 12"));
    }

    @Test
    public void update_changeDescription_isOk() throws IOException {
        Place place = placeMongoRepository.save(TestHelper.getValidPlace("España"));
        PlaceDTO placeDTO = placesServiceImpl.getById(place.getId());
        assertThat(placeDTO.getDescription(), is("España"));

        placeDTO = TestHelper.getValidPlaceDTO("Mexico");

        placesServiceImpl.update(place.getId(), placeDTO);
        assertThat(placesServiceImpl.getById(place.getId()).getDescription(), is("Mexico"));
    }

}