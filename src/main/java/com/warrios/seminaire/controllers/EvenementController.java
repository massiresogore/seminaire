package com.warrios.seminaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EvenementController {

    @GetMapping("/evenement")
    public String index()
    {
        return "evenement/index";
    }

}
