package com.bhagya.research.controller;

import com.bhagya.research.appmenu.service.AppMenuService;
import com.bhagya.research.core.dto.ImageButtonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppMenuController {
    @Autowired
    private AppMenuService appMenuService;

    @PostMapping("/getAppMenu")
    public List<ImageButtonDTO> getAppMenuContent() {
        return appMenuService.getAppMenu();
    }

}
