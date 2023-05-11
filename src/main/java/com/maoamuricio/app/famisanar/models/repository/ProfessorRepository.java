package com.maoamuricio.app.famisanar.models.repository;

import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {


}
