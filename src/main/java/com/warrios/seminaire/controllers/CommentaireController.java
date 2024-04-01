package com.warrios.seminaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentaireController {

    @GetMapping("/commentaire")
    public String index()
    {
        return "commentaire/index";
    }

}
