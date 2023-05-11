package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Professor;
import com.maoamuricio.app.famisanar.models.entities.Student;
import com.maoamuricio.app.famisanar.models.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfessorServiceImpl implements ProfessorService{



    @Autowired
    private ProfessorRepository professorRepository;


    @Override
    public List<Professor> listar() {
        return (List<Professor>) professorRepository.findAll();
    }

    @Override
    public Optional<Professor> encontrar(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public Professor guardar(Professor p) {
        return professorRepository.save(p);
    }

    @Override
    public void eliminar(Long id) {
        professorRepository.deleteById(id);
    }
}
