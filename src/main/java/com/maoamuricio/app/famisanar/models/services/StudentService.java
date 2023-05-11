package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Person;
import com.maoamuricio.app.famisanar.models.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {



    List<Student> listar();


    Optional<Student> encontrar(Long id);

    Person guardar(Student student);


    void eliminar(Long id);
}
