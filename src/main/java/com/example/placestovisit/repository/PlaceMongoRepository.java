package com.example.placestovisit.repository;

import com.example.placestovisit.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceMongoRepository extends MongoRepository<Place, String> {
}
