package com.enriquez.act1t4.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DatosController {

     // Endpoint c objeto simple
     @GetMapping("/alumno")
     public Map<String, Object> alumno(){
        Map<String, Object> informacion = new HashMap<>();
        informacion.put("nombre", "Enríquez Rodríguez Alejandro Guillermo");
        informacion.put("edad", "21");
        informacion.put("semestre", "6");
        informacion.put("carrera", "Ingeniería Sistemas Computacionales");
        return informacion;
     }
    
}