package com.example.placestovisit.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity Place
 */
@Document(collection = "places")
public class Place {

    @Transient
    public static final String SEQUENCE_NAME = "places_sequence";

    @Transient
    public static final String SORT_FIELD = "order";

    @Id
    private String id;
    private String description;
    private Binary image;
    private long order;

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

    public long getOrder() {
        return order;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setImage(final Binary image) {
        this.image = image;
    }
    public void setOrder(final long order) {
        this.order = order;
    }

}
