package com.warrios.seminaire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WarriorsController {

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

}
