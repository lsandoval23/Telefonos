package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.interfaceService.ITelefonoService;
import com.example.demo.modelo.Telefonos;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.Optional;


// La anotacion RestController interactua con la base de datos, y devuelve datos en formato json
// a quien haga la consulta.

@RestController
public class ControllerTelefonos {

    @Autowired
    private ITelefonoService service;
	
    @GetMapping("/listar_telefonos")
    public List<Telefonos> listar() {
        List<Telefonos> telefonos = service.listar();
         
        return  telefonos;
    }
    
    @GetMapping("/listar")
    public String listar_prueba() {
    	
        return  "es una prueba";
    }
    
    @GetMapping("/listar_id/{id}")
    public Optional<Telefonos> listar_id(@PathVariable int id) {
    	Optional<Telefonos> telefonos = service.listarid(id);
    	return telefonos;
    }
    
    @PostMapping("/save")
    public String save(@RequestBody Telefonos t) {
    	try {
    		int res = service.save(t);
    		if (res == 1) {
    			return "{\"error\":0,\"messenger\":\"Guardado con éxito el numero de telefono " + t.getNumero() + "\"}";
    		}else {
    			return "{\"error\":1,\"messenger\":\"Error inesperado... Revise el log de errores\"}";
    		}
		} catch (Exception e) {
			return "{\"error\":1,\"messenger\":\"" + e.getMessage()  +"\"}";
		}		
				
    }
    
    @PutMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
    	try {
    		service.eliminar(id);
    		return "{\"error\":0,\"messenger\":\"Eliminado con éxito\"}";
    	} catch (Exception e) {
			return "{\"error\":1,\"messenger\":\"" + e.getMessage()  +"\"}";
		}		
    }
    
}
