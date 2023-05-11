package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Person;
import com.maoamuricio.app.famisanar.models.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService{



    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> listar() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> encontrar(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person guardar(Person p) {
        return personRepository.save(p);
    }

    @Override
    public void eliminar(Long id) {
        personRepository.deleteById(id);
    }
}
