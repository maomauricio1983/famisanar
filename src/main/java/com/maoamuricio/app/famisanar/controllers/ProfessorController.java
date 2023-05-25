package com.maoamuricio.app.famisanar.controllers;


import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Professor;
import com.maoamuricio.app.famisanar.models.services.AddressService;
import com.maoamuricio.app.famisanar.models.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/professor")
public class ProfessorController {


    @Autowired
    private ProfessorService service;

    @Autowired
    private AddressService addressService;

    @GetMapping("/listar")
    public List<Professor> findAll() {
        return service.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Professor> encontrarById(@PathVariable Long id) {
        Optional<Professor> professorOptional = service.encontrar(id);
        return professorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Professor> crear(@RequestBody Professor professor) {


        Optional<Address> address = Optional.ofNullable(professor.getAddress());
        if (address.isPresent()) {
            addressService.guardar(professor.getAddress());
            professor.setAddress(professor.getAddress());
        }


        service.guardar(professor);

        return ResponseEntity.status(HttpStatus.CREATED).body(professor);    }


    @PutMapping("/{id}")
    public ResponseEntity<Professor> editar(@RequestBody Professor professor, @PathVariable Long id) {


        Optional<Professor> c = service.encontrar(id);
        if (c.isPresent()) {
            Professor professorDb = c.get();


            professorDb.setName(professor.getName());
            professorDb.setPhone(professor.getPhone());
            professorDb.setEmail(professor.getEmail());
            professorDb.setAddress(professor.getAddress());
            professorDb.setSalary(professor.getSalary());


            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(professorDb));
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> eliminar(@PathVariable Long id) {
        Optional<Professor> c = service.encontrar(id);
        if (c.isPresent()) {
            service.eliminar(id);
        }

        return ResponseEntity.notFound().build();
    }
}
