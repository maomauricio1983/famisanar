package com.maoamuricio.app.famisanar.controllers;


import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Student;
import com.maoamuricio.app.famisanar.models.services.AddressService;
import com.maoamuricio.app.famisanar.models.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService service;

    @Autowired
    private AddressService addressService;

    @GetMapping("/listar")
    public List<Student> findAll() {
        return service.listar();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> encontrarById(@PathVariable Long id) {
        Optional<Student> studentOptional = service.encontrar(id);
        return studentOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Student> crear(@RequestBody Student student) {


        return ResponseEntity.status(HttpStatus.CREATED).body((Student) service.guardar(student));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> editar(@RequestBody Student student, @PathVariable Long id) {


        Optional<Student> c = service.encontrar(id);
        if (c.isPresent()) {
            Student studentDb = c.get();


            studentDb.setName(student.getName());
            studentDb.setPhone(student.getPhone());
            studentDb.setEmail(student.getEmail());
            studentDb.setAddress(student.getAddress());
            studentDb.setStudentNumber(student.getStudentNumber());
            studentDb.setAverageMark(student.getAverageMark());


            return ResponseEntity.status(HttpStatus.CREATED).body((Student) service.guardar(studentDb));
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> eliminar(@PathVariable Long id) {
        Optional<Student> c = service.encontrar(id);
        if (c.isPresent()) {
            Student studentDb = c.get();

            service.eliminar(id);
        }

        return ResponseEntity.notFound().build();
    }
}
