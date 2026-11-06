package com.example.pmngservicios.repository;


import com.example.pmngservicios.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
