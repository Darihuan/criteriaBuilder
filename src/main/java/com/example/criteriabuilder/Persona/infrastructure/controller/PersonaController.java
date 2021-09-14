package com.example.criteriabuilder.Persona.infrastructure.controller;

import com.example.criteriabuilder.Persona.domain.Persona;
import com.example.criteriabuilder.Persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class PersonaController {
    @Autowired
    PersonaRepository repository;
    @GetMapping("/personas")
    public List<Persona> getPersonas(@RequestParam(required = false) Integer idPersona,
                                     @RequestParam(required = false) String nombre,
                                     @RequestParam(required = false) String direccion,
                                     @RequestParam(required = false) String email,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date registro) {
        HashMap<String, Object> data = new HashMap<>();
        if (idPersona != null) {
            data.put("id", idPersona);
        }
        if (nombre != null) {
            data.put("nombre", nombre);

        }
        if (direccion != null) {
            data.put("direccion", direccion);
        }
        if (email != null) {
            data.put("email", direccion);
        }
        if (registro != null) {
            data.put("registro", registro);
        }

        return repository.getData(data);
    }

}
