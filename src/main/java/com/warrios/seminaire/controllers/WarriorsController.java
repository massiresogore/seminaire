package com.warrios.seminaire.controllers;

import com.warrios.seminaire.modeles.*;
import com.warrios.seminaire.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class WarriorsController {
    private final UtilisateurService utilisateurService;

    public WarriorsController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @GetMapping("/")
    public String index()
    {

        return "index";
    }

}
