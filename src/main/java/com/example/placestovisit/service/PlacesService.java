package com.example.placestovisit.service;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.model.PlaceDTO;

import java.io.IOException;
import java.util.List;

public interface PlacesService {

    Place create(final PlaceDTO placeDTO) throws IOException;

    List<PlaceDTO> getAll();
}
