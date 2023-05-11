package com.maoamuricio.app.famisanar.models.services;

import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.entities.Person;
import com.maoamuricio.app.famisanar.models.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressServiceImpl implements AddressService{



    @Autowired
    private AddressRepository addressRepository;


    @Override
    public List<Address> listar() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Optional<Address> encontrar(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address guardar(Address p) {
        return addressRepository.save(p);
    }

    @Override
    public void eliminar(Long id) {
        addressRepository.deleteById(id);
    }
}
