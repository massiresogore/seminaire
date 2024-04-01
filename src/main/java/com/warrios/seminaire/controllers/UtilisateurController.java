package com.warrios.seminaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {

    @GetMapping("/utilisateur")
    public String index()
    {
        return "utilisateur/index";
    }

}
