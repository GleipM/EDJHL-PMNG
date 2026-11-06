package com.example.pmngservicios.service;

import com.example.pmngservicios.entity.Person;
import com.example.pmngservicios.kernel.ApiResponse;
import com.example.pmngservicios.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public ResponseEntity<ApiResponse> save(Person person){
        try {
            Person persona = personRepository.save(person);
            ApiResponse respuesta = new ApiResponse(
                    "Guardado correctamente",
                    persona,
                    false,
                    HttpStatus.CREATED
                    );
            return new ResponseEntity<>(respuesta, respuesta.getStatus());
        }catch (Exception e){
            System.out.printf(String.valueOf(e));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<ApiResponse> getAll(){
        try {
            List<Person> people = personRepository.findAll();
            ApiResponse respuesta = new ApiResponse(
                    "Encontrados correctamente",
                    people,
                    false,
                    HttpStatus.OK
            );
            return new ResponseEntity<>(respuesta, respuesta.getStatus());
        } catch (Exception e){
            System.out.printf(String.valueOf(e));
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
