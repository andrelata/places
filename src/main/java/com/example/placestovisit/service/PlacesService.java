package com.example.placestovisit.service;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.model.PlaceDTO;

import java.io.IOException;
import java.util.List;

public interface PlacesService {

    /**
     * @param placeDTO
     * @return Place
     * @throws IOException
     */
    Place create(final PlaceDTO placeDTO) throws IOException;

    /**
     * @return List of PlaceDTO
     */
    List<PlaceDTO> getAll();

    /**
     * @param id Place id
     * @throws IllegalArgumentException if the place does not exist
     */
    void remove(final String id);
}
