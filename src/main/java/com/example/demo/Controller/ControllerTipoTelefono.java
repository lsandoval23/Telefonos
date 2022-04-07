package com.example.demo.Controller;

import com.example.demo.modelo.Telefonos;
import com.example.demo.modelo.TipoTelefono;
import com.example.demo.service.TipoTelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
