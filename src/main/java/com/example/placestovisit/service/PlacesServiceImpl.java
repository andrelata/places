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
    public void create(PlaceDTO placeDTO) throws IOException {
        placeMongoRepository.save(PlaceMapper.toPlace(placeDTO));
    }

    @Override
    public List<PlaceDTO> getAll() {
        final List<Place> places = placeMongoRepository.findAll();
        return places.stream()
                .map(PlaceMapper::toPlaceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(final String id) {
        final Place place = getPlace(id);
        placeMongoRepository.delete(place);
    }

    @Override
    public PlaceDTO getById(final String id) {
        final Place place = getPlace(id);
        return PlaceMapper.toPlaceDTO(place);
    }

    @Override
    public void update(final String id, final PlaceDTO placeDTO) throws IOException {
        Place place = PlaceMapper.updatePlace(getPlace(id), placeDTO);
        placeMongoRepository.save(place);
    }

    private Place getPlace(final String id) {
        return placeMongoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid place Id:" + id));
    }

}
