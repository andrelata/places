package com.example.placestovisit.service;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.repository.PlaceMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    private PlaceMongoRepository placeMongoRepository;

    @Override
    public Place create(Place place) {
        return placeMongoRepository.save(place);
    }

}
