package com.example.criteriabuilder.Persona.infrastructure.repository.jpa;


import com.example.criteriabuilder.Persona.domain.Persona;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PersonaRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Persona> getData(HashMap<String,Object> condiciones) {
        CriteriaBuilder critbuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = critbuilder.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        condiciones.forEach((campo, valor) -> {
            switch (campo) {
                case "id":
                    predicates.add(critbuilder.equal(root.get(campo), (Integer) valor));
                    break;
                case "nombre":
                    predicates.add(critbuilder.like(root.get(campo), "%" + (String) valor + "%"));
                    break;
                case "email":
                    predicates.add(critbuilder.like(root.get(campo), "%" + (String) valor + "%"));
                    break;
                case "direccion":
                    predicates.add(critbuilder.like(root.get(campo), "%" + (String) valor + "%"));
                    break;
                case "registro":
                    predicates.add(critbuilder.greaterThan(root.<Date>get(campo), (Date) valor));
                    break;


            }


        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();

    }


}
