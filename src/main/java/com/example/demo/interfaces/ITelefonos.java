package com.example.demo.interfaces;

import com.example.demo.modelo.Telefonos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefonos extends CrudRepository <Telefonos, Integer> {

}


