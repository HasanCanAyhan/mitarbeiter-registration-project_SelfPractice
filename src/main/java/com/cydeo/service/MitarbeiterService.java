package com.cydeo.service;

import com.cydeo.model.Mitarbeiter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MitarbeiterService { // service is a Bean

    public static List<Mitarbeiter> mitarbeiterList = new ArrayList<>();

    public void saveMitarbeiter(Mitarbeiter mitarbeiter){
        mitarbeiterList.add(mitarbeiter);

    }

    public List<Mitarbeiter>  readAllMitarbeiters(){
        return mitarbeiterList;
    }


}
