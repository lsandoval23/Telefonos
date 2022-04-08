package com.example.demo.interfaceService;

import com.example.demo.modelo.TipoTelefono;

import java.util.List;

public interface ITipoTelefonoService {

    public List<TipoTelefono> listarTipoTelefonos();
    public int save(TipoTelefono tipoTelefono);
    public void delete(int idTipoTelefono);
}
