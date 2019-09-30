package com.cpe.backend.controller;
import com.cpe.backend.entity.FoodImage;
import com.cpe.backend.entity.FoodTechinque;
import com.cpe.backend.entity.*;
import com.cpe.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cpe.backend.model.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MenuDesignController {
    @Autowired
    private final MenuDesignRepository menuDesignRepository;
    @Autowired
    private MenuListRepository menuListRepository;
    @Autowired
    private FoodImageRepository foodImageRepository;
    @Autowired
    private FoodTechinqueRepository foodTechinqueRepository;

    MenuDesignController(MenuDesignRepository menuDesignRepository, MenuListRepository menuListRepository,
            FoodImageRepository foodImageRepository, FoodTechinqueRepository foodTechinqueRepository) {
        this.menuDesignRepository = menuDesignRepository;
        this.menuListRepository = menuListRepository;
        this.foodImageRepository = foodImageRepository;
        this.foodTechinqueRepository = foodTechinqueRepository;
    }

    @GetMapping("/getMenuDesign")
    public Collection<MenuDesign> MenuDesign() {
        return menuDesignRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/createMenuDesign/{menuListId}/{foodImageId}/{foodTechinqueId}/{desc}")
    public MenuDesign newMenuDesign(MenuDesign newMenuDesign, @PathVariable long menuListId,
            @PathVariable long foodTechinqueId, @PathVariable long foodImageId, @PathVariable String desc) {

        MenuList menuList = menuListRepository.findById(menuListId);
        FoodTechinque foodTechinque = foodTechinqueRepository.findById(foodTechinqueId);
        FoodImage foodImage = foodImageRepository.findById(foodImageId);

        newMenuDesign.setMenuList(menuList);
        newMenuDesign.setFoodTechinque(foodTechinque);
        newMenuDesign.setFoodImage(foodImage);
        newMenuDesign.setDesciption(desc);

        return menuDesignRepository.save(newMenuDesign); // บันทึก Objcet ชื่อ MenuDesign
    }

    @PostMapping("/createWithUrl")
    @ResponseBody
    public MenuDesign newMenuDesign(@RequestBody MenuDesignBody menuBody)

    {

        FoodImage foodImage = new FoodImage();
        foodImage.setNameImage(menuBody.nameImage);
        foodImage.setUrlImage(menuBody.urlImage);
        foodImageRepository.save(foodImage);

        MenuList menuList = menuListRepository.findById(menuBody.menuListId);
        FoodTechinque foodTechinque = foodTechinqueRepository.findById(menuBody.foodTechinqueId);

        MenuDesign newMenuDesign = new MenuDesign();
        newMenuDesign.setMenuList(menuList);
        newMenuDesign.setFoodTechinque(foodTechinque);
        newMenuDesign.setDesciption(menuBody.desc);
        newMenuDesign.setFoodImage(foodImage);
        return menuDesignRepository.save(newMenuDesign); // บันทึก Objcet ชื่อ MenuDesign
    }

}