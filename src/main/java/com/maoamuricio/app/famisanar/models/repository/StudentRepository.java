package com.maoamuricio.app.famisanar.models.repository;

import com.maoamuricio.app.famisanar.models.entities.Person;
import com.maoamuricio.app.famisanar.models.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {


}
