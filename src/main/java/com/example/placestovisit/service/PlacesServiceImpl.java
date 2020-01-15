package com.example.placestovisit.service;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.model.PlaceDTO;
import com.example.placestovisit.model.PlaceMapper;
import com.example.placestovisit.repository.PlaceMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    private PlaceMongoRepository placeMongoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void create(PlaceDTO placeDTO) throws IOException {
        Place place = PlaceMapper.toPlace(placeDTO);
        place.setOrder(sequenceGeneratorService.getNextSequence(Place.SEQUENCE_NAME));
        placeMongoRepository.save(place);
    }

    @Override
    public List<PlaceDTO> getSortByOrder() {
        final List<Place> places = placeMongoRepository.findAll(
                Sort.by(Sort.Direction.ASC, Place.SORT_FIELD));
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
                .orElseThrow(() -> new IllegalArgumentException("Invalid place Id: " + id));
    }

}
