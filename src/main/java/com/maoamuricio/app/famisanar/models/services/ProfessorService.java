package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {



    List<Professor> listar();


    Optional<Professor> encontrar(Long id);

    Professor guardar(Professor p);


    void eliminar(Long id);
}
