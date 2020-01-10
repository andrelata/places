package com.example.placestovisit.service;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.model.PlaceDTO;
import com.example.placestovisit.model.PlaceMapper;
import com.example.placestovisit.repository.PlaceMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    private PlaceMongoRepository placeMongoRepository;

    @Override
    public Place create(PlaceDTO placeDTO) throws IOException {
        return placeMongoRepository.save(PlaceMapper.toPlace(placeDTO));
    }

    @Override
    public List<PlaceDTO> getAll() {
        final List<Place> places = placeMongoRepository.findAll();
        return places.stream()
                .map(PlaceMapper::toPlaceDTO)
                .collect(Collectors.toList());
    }

}
