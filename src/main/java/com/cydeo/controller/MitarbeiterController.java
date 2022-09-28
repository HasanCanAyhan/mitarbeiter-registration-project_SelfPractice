package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    @GetMapping("/register")
    public String createMitarbeiter(){


        return "mitarbeiter/mitarbeiter-create";

    }



}
