package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {



    List<Person> listar();


    Optional<Person> encontrar(Long id);

    Person guardar(Person p);


    void eliminar(Long id);
}
