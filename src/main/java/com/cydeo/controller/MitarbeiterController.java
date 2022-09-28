package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Mitarbeiter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    @GetMapping("/register")
    public String createMitarbeiter(Model model){

        model.addAttribute("mitarbeiter",new Mitarbeiter());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "mitarbeiter/mitarbeiter-create";

    }



}
