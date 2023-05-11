package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Person;

import java.util.List;
import java.util.Optional;

public interface AddressService {



    List<Address> listar();


    Optional<Address> encontrar(Long id);

    Address guardar(Address p);


    void eliminar(Long id);
}
