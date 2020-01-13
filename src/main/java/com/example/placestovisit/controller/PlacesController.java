package com.example.placestovisit.controller;

import com.example.placestovisit.model.PlaceDTO;
import com.example.placestovisit.service.PlacesService;
import com.example.placestovisit.validator.PlaceParamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    private PlaceParamValidator placeParamValidator = new PlaceParamValidator();

    @GetMapping("/")
    public String index(final Model model) {
        final List<PlaceDTO> places = placesService.getSortByOrder();
        model.addAttribute("places", places);
        return "index";
    }

    @PostMapping("/add")
    public String addPlace(final @RequestParam("description") String description,
                           final @RequestParam("image") MultipartFile image) {
        try {
            final PlaceDTO placeDTO = new PlaceDTO(description, image);
            placeParamValidator.validate(placeDTO);
            placesService.create(placeDTO);
        } catch (IOException e) {
            //TODO manejo de errores
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAdd() {
        return "add-place";
    }

    @GetMapping("/delete/{id}")
    public String delete(final @PathVariable("id") String id) {
        try {
            placesService.remove(id);
        } catch (IllegalArgumentException e) {
            //TODO manejo de errores
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(final @PathVariable("id") String id, final Model model) {
        try {
            final PlaceDTO placeDTO = placesService.getById(id);
            model.addAttribute("place", placeDTO);
        } catch (IllegalArgumentException e) {
            //TODO manejo de errores
            e.printStackTrace();
        }
        return "update-place";
    }

    @PostMapping("/edit/{id}")
    public String updatePlace(final @PathVariable("id") String id,
                              final @RequestParam("description") String description,
                              final @RequestParam("image") MultipartFile image) {
        try {
            final PlaceDTO placeDTO = new PlaceDTO(description, image);
            placeParamValidator.validate(placeDTO);
            placesService.update(id, placeDTO);
        } catch (IOException e) {
            //TODO manejo de errores
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
