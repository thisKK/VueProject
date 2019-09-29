package com.cpe.backend.controller;

import com.cpe.backend.entity.MenuList;
import com.cpe.backend.repository.MenuListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MenuListController {

    @Autowired
    private final MenuListRepository menuListRepository;

    public MenuListController(MenuListRepository menuListRepository) {
        this.menuListRepository = menuListRepository;
    }

    @GetMapping("/getMenuList")
    public Collection<MenuList> getMenuLists() {
        return menuListRepository.findAll().stream().collect(Collectors.toList());
    }

}