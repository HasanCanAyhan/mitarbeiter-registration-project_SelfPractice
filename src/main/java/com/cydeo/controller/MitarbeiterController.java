package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Mitarbeiter;
import com.cydeo.service.MitarbeiterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // inside it there is @Component
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    //Dependency Injection

    private final MitarbeiterService mitarbeiterService;

    public MitarbeiterController(MitarbeiterService mitarbeiterService) {
        this.mitarbeiterService = mitarbeiterService;
    }

    @GetMapping("/register")
    public String createMitarbeiter(Model model){

        model.addAttribute("mitarbeiter",new Mitarbeiter());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "mitarbeiter/mitarbeiter-create";

    }


    @PostMapping("/insert")
    public String insertMitarbeiter(@ModelAttribute("mitarbeiter") Mitarbeiter mitarbeiter){ // to capture object which is sent from UI-part
        mitarbeiterService.saveMitarbeiter(mitarbeiter);

        return "mitarbeiter/mitarbeiter-list";
    }



}
