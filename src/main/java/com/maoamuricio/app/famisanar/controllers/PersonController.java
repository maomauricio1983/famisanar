package com.maoamuricio.app.famisanar.controllers;


import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Person;
import com.maoamuricio.app.famisanar.models.services.AddressService;
import com.maoamuricio.app.famisanar.models.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonService service;

    @Autowired
    private AddressService addressService;

    @GetMapping("/listar")
    public List<Person> findAll() {
        return service.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> encontrarById(@PathVariable Long id) {
        Optional<Person> personOptional = service.encontrar(id);
        return personOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Person> crear(@RequestBody Person person) {


        Optional<Address> address = Optional.ofNullable(person.getAddress());
        if (address.isPresent()) {
            addressService.guardar(person.getAddress());
            person.setAddress(person.getAddress());
        }


        service.guardar(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Person> editar(@RequestBody Person person, @PathVariable Long id) {


        Optional<Person> c = service.encontrar(id);
        if (c.isPresent()) {
            Person personDb = c.get();


            personDb.setName(person.getName());
            personDb.setPhone(person.getPhone());
            personDb.setEmail(person.getEmail());



            return ResponseEntity.status(HttpStatus.CREATED).body((Person) service.guardar(personDb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> eliminar(@PathVariable Long id) {
        Optional<Person> c = service.encontrar(id);
        if (c.isPresent()) {
            Person personDb = c.get();

            service.eliminar(id);
        }

        return ResponseEntity.notFound().build();
    }
}
