package com.cpe.backend.menu.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.menu.entity.*;
import com.cpe.backend.menu.repository.*;
import com.cpe.backend.menu.model.*;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MenuController {

    @Autowired
    private final MenuRepository menuRepository;
    @Autowired
    private final MenuTypeRepository menuTypeRepository;
    @Autowired
    private final NationRepository nationRepository;
    @Autowired
    private final AppropriateRepository appropriateRepository;

    MenuController(MenuRepository menuRepository,MenuTypeRepository menuTypeRepository,NationRepository nationRepository,AppropriateRepository appropriateRepository) {
        this.menuRepository = menuRepository;
        this.menuTypeRepository = menuTypeRepository;
        this.nationRepository = nationRepository;
        this.appropriateRepository = appropriateRepository;
    }

    @GetMapping("/getMenu")
    public Collection<Menu> getMenus() {
        return menuRepository.findAll().stream().collect(Collectors.toList());
    }

    
    @PostMapping("/menu")
    public Menu index(Menu newMenu,@RequestBody BodyMenu bodyMenu) {

        newMenu.setMenuTypeID(menuTypeRepository.findById(bodyMenu.menuTypeId).get());
        newMenu.setNationID(nationRepository.findById(bodyMenu.nationId).get());
        newMenu.setAppropriateID(appropriateRepository.findById(bodyMenu.appropriateId).get());

        newMenu.setMenuName(bodyMenu.menuName);
        newMenu.setMenuPrice(bodyMenu.menuPrice);
        newMenu.setMenuUnits(bodyMenu.menuUnits);
        return menuRepository.save(newMenu);
    }

}