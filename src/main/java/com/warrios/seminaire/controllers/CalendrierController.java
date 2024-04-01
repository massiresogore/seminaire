package com.warrios.seminaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendrierController {

    @GetMapping("/calendrier")
    public String index()
    {
        return "calendrier/index";
    }

}
