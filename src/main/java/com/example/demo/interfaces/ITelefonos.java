package com.example.demo.interfaces;

import com.example.demo.modelo.Telefonos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// El repository se encarga de interactuar directamente con la base de datos a traves
// de la clase padre CrudRepository
@Repository
public interface ITelefonos extends CrudRepository <Telefonos, Integer> {

}


