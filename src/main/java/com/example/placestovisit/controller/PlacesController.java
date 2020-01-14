package com.example.placestovisit.controller;

import com.example.placestovisit.model.PlaceDTO;
import com.example.placestovisit.service.PlacesService;
import com.example.placestovisit.validator.PlaceParamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
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
                           final @RequestParam("image") MultipartFile image,
                           final Model model) throws IOException {
        try {
            final PlaceDTO placeDTO = new PlaceDTO(description, image);
            placeParamValidator.validate(placeDTO);
            placesService.create(placeDTO);
            return "redirect:/";
        } catch (ValidationException e) {
            model.addAttribute("description", description);
            model.addAttribute("image", image);
            model.addAttribute("errors", e.getMessage());
            return "add-place";
        }

    }

    @GetMapping("/add")
    public String showAdd() {
        return "add-place";
    }

    @GetMapping("/delete/{id}")
    public String delete(final @PathVariable("id") String id) {
        placesService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(final @PathVariable("id") String id, final Model model) {
        final PlaceDTO placeDTO = placesService.getById(id);
        model.addAttribute("place", placeDTO);
        return "update-place";
    }

    @PostMapping("/edit/{id}")
    public String updatePlace(final @PathVariable("id") String id,
                              final @RequestParam("description") String description,
                              final @RequestParam("image") MultipartFile image,
                              final Model model) throws IOException {
        final PlaceDTO placeDTO = new PlaceDTO(description, image);
        try {
            placeParamValidator.validate(placeDTO);
            placesService.update(id, placeDTO);
            return "redirect:/";
        } catch (ValidationException e) {
            model.addAttribute("errors", e.getMessage());
            model.addAttribute("place", placeDTO);
            return "update-place";
        }
    }

    @ExceptionHandler({ IOException.class, IllegalArgumentException.class})
    public String handleException(final Exception e) {
        //TODO add log with error
        return "error";
    }

}
