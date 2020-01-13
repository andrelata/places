package com.example.placestovisit.service;

import com.example.placestovisit.model.PlaceDTO;

import java.io.IOException;
import java.util.List;

public interface PlacesService {

    /**
     * @param placeDTO
     * @return Place
     * @throws IOException
     */
    void create(final PlaceDTO placeDTO) throws IOException;

    /**
     * @return List of PlaceDTO
     */
    List<PlaceDTO> getSortByOrder();

    /**
     * @param id Place id
     * @throws IllegalArgumentException if the place does not exist
     */
    void remove(final String id);

    /**
     * @param id Place id
     * @return Place
     * @throws IllegalArgumentException if the place does not exist
     */
    PlaceDTO getById(final String id);

    /**
     * @param id Place id
     * @param placeDTO
     * @throws IOException
     */
    void update(final String id, final PlaceDTO placeDTO) throws IOException;
}
