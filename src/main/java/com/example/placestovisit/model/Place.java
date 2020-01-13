package com.example.placestovisit.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity Place
 */
@Document(collection = "places")
public class Place {

    @Id
    private String id;
    private String description;
    private Binary image;

    public Place(final String description, final Binary image) {
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Binary getImage() {
        return image;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setImage(final Binary image) {
        this.image = image;
    }
}
