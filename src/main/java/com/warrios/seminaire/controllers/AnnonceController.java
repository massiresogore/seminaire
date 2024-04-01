package com.warrios.seminaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnonceController {

    @GetMapping("/annonce")
    public String index()
    {
        return "annonce/index";
    }

}
