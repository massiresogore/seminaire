package com.warrior.seminaire.controllers;


import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String home(){
        return "index";
    }
}
