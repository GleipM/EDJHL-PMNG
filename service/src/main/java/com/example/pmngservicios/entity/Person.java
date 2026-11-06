package com.example.pmngservicios.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator
    private Integer id;

    private String name;
}
