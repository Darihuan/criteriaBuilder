package com.example.criteriabuilder.Persona.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name ="nombre", nullable = false)
    String nombre;
    @Column(name = "email",nullable = false)
    String email;
    @Column(name = "direccion")
    String direccion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    Date registro;

}
