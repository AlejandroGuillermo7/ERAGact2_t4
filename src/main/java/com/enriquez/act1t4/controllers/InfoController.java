package com.enriquez.act1t4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InfoController {

    // Endpoint a identifica el proyecto
    @GetMapping("/identificacion")
    public String identificacion(){
        return "Proyecto Act1 T4 - Enríquez Rodríguez Alejandro Guillermo (ERAG)";
    }

    // Endpoint b regresa una lista simulada (lista de materias)
    @GetMapping("/materias")
    public List<String> materias(){
        return List.of(
            "Programación Web",
            "Automátas 2",
            "Conmutación",
            "Taller de investigación 2"
        );
    }
}