package com.example.pmngservicios.controller;

import com.example.pmngservicios.entity.Person;
import com.example.pmngservicios.kernel.ApiResponse;
import com.example.pmngservicios.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "*")
public class PersonControlller {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAll(){
        return personService.getAll();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody Person person){
        return personService.save(person);
    }
}
