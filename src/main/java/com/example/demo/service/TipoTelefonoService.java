package com.example.demo.service;

import com.example.demo.interfaceService.ITipoTelefonoService;
import com.example.demo.interfaces.ITipoTelefono;
import com.example.demo.modelo.Telefonos;
import com.example.demo.modelo.TipoTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTelefonoService implements ITipoTelefonoService {

    /** Atributos */
    // Crud
    @Autowired
    private ITipoTelefono data;

    /** Metodos */

    // Lista todos los tipos de telefono
    @Override
    public List<TipoTelefono> listarTipoTelefonos() {
        return (List<TipoTelefono>) data.findAll();
    }

    // Guarda un nuevo tipo de telefono
    @Override
    public int save(TipoTelefono t) {
        int res = 0;
        TipoTelefono tipoTelefono = data.save(t);
        if (tipoTelefono != null) {
            res = 1;
        }
        return res;
    }

    // Elimina un tipo de telefono
    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
