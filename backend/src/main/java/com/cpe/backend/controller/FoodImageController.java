package com.cpe.backend.controller;

import com.cpe.backend.entity.FoodImage;
import com.cpe.backend.repository.FoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FoodImageController {

    @Autowired
    private final FoodImageRepository foodImageRepository;

    public FoodImageController(FoodImageRepository foodImageRepository) {

        this.foodImageRepository = foodImageRepository;
    }

    @GetMapping("/getFoodImage")
    public Collection<FoodImage> foodImages() {
        return foodImageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/foodimage/{id}")
    public Optional<FoodImage> foodimage(@PathVariable Long id) {
        Optional<FoodImage> foodimage = foodImageRepository.findById(id);
        return foodimage;
    }

    // @PostMapping("/postImage/{nameImage}/{urlImage}")
    // public FoodImage newFoodImage(FoodImage newFoodImage,
    // @PathVariable String nameImage,
    // @PathVariable String urlImage
    // ){    
    //     newFoodImage.setNameImage(nameImage);
    //     newFoodImage.setUrlImage(urlImage);
    
    //     return foodImageRepository.save(newFoodImage); //บันทึก Objcet ชื่อ FoodImage
    //     }
}