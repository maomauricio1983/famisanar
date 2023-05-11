package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Student;
import com.maoamuricio.app.famisanar.models.entities.Student;
import com.maoamuricio.app.famisanar.models.repository.StudentRepository;
import com.maoamuricio.app.famisanar.models.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{



    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> listar() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Optional<Student> encontrar(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student guardar(Student p) {
        return studentRepository.save(p);
    }

    @Override
    public void eliminar(Long id) {
        studentRepository.deleteById(id);
    }
}
