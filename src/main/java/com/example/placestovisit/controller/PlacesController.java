package com.example.placestovisit.controller;

import com.example.placestovisit.model.Place;
import com.example.placestovisit.service.PlacesService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping(value="/add")
    public String addPlace(final @RequestParam("description") String description,
                           final @RequestParam("image") MultipartFile image) {
        try {
            final Binary imagePlace = new Binary(BsonBinarySubType.BINARY, image.getBytes());
            placesService.create(new Place(description, imagePlace));
        } catch (IOException e) {
            //TODO manejo de errores
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping(value="/add")
    public String showAdd() {
        return "add-place";
    }

}
