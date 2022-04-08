package com.example.demo.Controller;

import com.example.demo.modelo.Telefonos;
import com.example.demo.modelo.TipoTelefono;
import com.example.demo.service.TipoTelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerTipoTelefono {

    /** Atributos */

    @Autowired
    private TipoTelefonoService service;

    /** Metodos */

    @GetMapping("/listar_tipo_telefono")
    public List<TipoTelefono> listar(){
        return  service.listarTipoTelefonos();
    }

    @PostMapping("/save_tipo_telefono")
    public String save(@RequestBody TipoTelefono t) {
        try {
            int res = service.save(t);
            if (res == 1) {
                return "{\"error\":0,\"messenger\":\"Guardado con éxito el tipo de telefono " + t.getNombre() + "\"}";
            }else {
                return "{\"error\":1,\"messenger\":\"Error inesperado... Revise el log de errores\"}";
            }
        } catch (Exception e) {
            return "{\"error\":1,\"messenger\":\"" + e.getMessage()  +"\"}";
        }
    }

    @PutMapping("/eliminar_tipo/{id}")
    public String eliminar(@PathVariable int id) {
        try {
            service.delete(id);
            return "{\"error\":0,\"messenger\":\"Eliminado con éxito\"}";
        } catch (Exception e) {
            return "{\"error\":1,\"messenger\":\"" + e.getMessage()  +"\"}";
        }
    }

}
