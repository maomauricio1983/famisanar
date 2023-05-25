package com.maoamuricio.app.famisanar.controllers;


import com.maoamuricio.app.famisanar.models.entities.Address;
import com.maoamuricio.app.famisanar.models.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private AddressService service;

    @GetMapping("/listar")
    public List<Address> findAll(){
        return service.listar(); }


    @GetMapping("/{id}")
    public ResponseEntity<Address> encontrarById(@PathVariable Long id) {
        Optional<Address> addressOptional = service.encontrar(id);
        return addressOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Address> crear(@RequestBody Address address) {



        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(address));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Address> editar( @RequestBody Address address, @PathVariable Long id) {



        Optional<Address> c = service.encontrar(id);
        if (c.isPresent()) {
            Address addressDb =  c.get();
            addressDb.setCity(address.getCity());
            addressDb.setCountry(address.getCountry());
            addressDb.setState(address.getState());
            addressDb.setStreet(address.getStreet());
            addressDb.setPostalCode(address.getPostalCode());
            addressDb.setCity(addressDb.getCity());


            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(addressDb));
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Address> eliminar(@PathVariable Long id){
        Optional<Address> c = service.encontrar(id);
        if (c.isPresent()) {

            service.eliminar(id);
        }

        return ResponseEntity.notFound().build();
    }
}
