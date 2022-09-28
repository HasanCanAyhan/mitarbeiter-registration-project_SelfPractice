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

        //model.addAttribute("employeeList", employeeService.readAllEmployees());
        //but it is one another business logic, according to Single responsibility you should use another method for returning mitarbeiter-list

        return "redirect:/mitarbeiter/list"; // endpoints , return the following method
    }

    @GetMapping("/list")
    public String listMitarbeiters(Model model){

        model.addAttribute("mitarbeiterList",mitarbeiterService.readAllMitarbeiters());

        return "mitarbeiter/mitarbeiter-list"; // html file paths

    }



}
