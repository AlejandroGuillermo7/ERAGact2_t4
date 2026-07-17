package com.enriquez.act1t4.controllers;

import com.enriquez.act1t4.models.dto.CamionetaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamionetaRestController {

    @PostMapping("/api/camionetas")
    public CamionetaDTO crearCamioneta(@RequestBody CamionetaDTO camioneta) {
       
        return camioneta;
    }
}