package com.maoamuricio.app.famisanar.models.repository;

import com.maoamuricio.app.famisanar.models.entities.Person;
import org.springframework.data.repository.CrudRepository;

    public interface PersonRepository extends CrudRepository<Person, Long> {


}
