package com.example.criteriabuilder.Persona.infrastructure.repository.jpa;


import com.example.criteriabuilder.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    public List<Persona> getData(HashMap<String,Object> condiciones);
}
