package com.example.placestovisit.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Place DTO
 */
public class PlaceDTO {

    private String id;
    private String description;
    private MultipartFile file;
    private String image;
    private long order;

    public PlaceDTO(final String description, final MultipartFile file) {
        this.description = description;
        this.file = file;
    }

    public PlaceDTO(final String id, final String description, final MultipartFile file) {
        this.id = id;
        this.description = description;
        this.file = file;
    }

    public PlaceDTO(final String id, final String description, final String image, final long order) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public long getOrder() {
        return order;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
