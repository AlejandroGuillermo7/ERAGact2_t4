package com.enriquez.act1t4.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.enriquez.act1t4.models.dto.CamionetaDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CamionetaController {

    @Value("${proyecto.nombre}")
    private String nombreProyecto;

    private List<CamionetaDTO> camionetas = new ArrayList<>(List.of(
        new CamionetaDTO(2024, "Pickup", 1, "Ford", "F-150", 45999.99),
        new CamionetaDTO(2023, "Pickup", 2, "Toyota", "Hilux", 58999.99),
        new CamionetaDTO(2024, "SUV", 3, "Jeep", "Grand Cherokee", 52999.99),
        new CamionetaDTO(2023, "SUV", 4, "Chevrolet", "Suburban", 61999.99),
        new CamionetaDTO(2024, "Pickup", 5, "Ford", "Raptor", 78999.99),
        new CamionetaDTO(2024, "Pickup", 6, "Nissan", "Frontier", 48999.99)
    ));

    @GetMapping("/camionetas")
    public String listaCamionetas(@RequestParam(required = false) String categoria, Model model){
        List<CamionetaDTO> resultado = new ArrayList<>();

        if (categoria != null && !categoria.isEmpty()) {
            for (CamionetaDTO c : camionetas) {
                if (c.getCategoria().equalsIgnoreCase(categoria)) {
                    resultado.add(c);
                }
            }
        } else {
            resultado = camionetas;
        }

        model.addAttribute("camionetas", resultado);
        model.addAttribute("nombreProyecto", nombreProyecto);

        return "camionetas";
    }

    @GetMapping("/camionetas/{id}")
    public String detalleCamioneta(@PathVariable int id, Model model) {
        CamionetaDTO camioneta = null;

        for (CamionetaDTO c : camionetas) {
            if (c.getId() == id) {
                camioneta = c;
                break;
            }
        }

        model.addAttribute("camioneta", camioneta);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "detalle";
    }

    @GetMapping("/camionetas/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("camioneta", new CamionetaDTO());
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "formulario";
    }

    @PostMapping("/camionetas/nueva")
    public String procesarFormulario(@ModelAttribute CamionetaDTO camioneta, Model model) {
        camioneta.setId(camionetas.size() + 1);
        camionetas.add(camioneta);

        model.addAttribute("camioneta", camioneta);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "confirmacion";
    }
}