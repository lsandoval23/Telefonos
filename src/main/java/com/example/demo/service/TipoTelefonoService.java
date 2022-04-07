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
    @Autowired
    private ITipoTelefono data;

    /** Metodos */
    @Override
    public List<TipoTelefono> listarTipoTelefonos() {
        return (List<TipoTelefono>) data.findAll();
    }

    @Override
    public int save(TipoTelefono t) {
        int res = 0;
        TipoTelefono tipoTelefono = data.save(t);
        if (tipoTelefono != null) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(TipoTelefono tipoTelefono) {

    }
}
