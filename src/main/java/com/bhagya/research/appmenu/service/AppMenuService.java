package com.bhagya.research.appmenu.service;

import com.bhagya.research.core.dto.ImageButtonDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppMenuService {

    public List<ImageButtonDTO> getAppMenu() {
        List<ImageButtonDTO> menuItems = new ArrayList<>();
        menuItems.add(new ImageButtonDTO("New Tour", "beach"));
        menuItems.add(new ImageButtonDTO("My Tours", "city"));
        return menuItems;
    }

}
