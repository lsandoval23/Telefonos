package com.example.demo.interfaceService;

import com.example.demo.modelo.Telefonos;

import java.util.List;
import java.util.Optional;

public interface ITelefonoService {
    public List<Telefonos>listar();
    public Optional<Telefonos>listarid(int id);
    public  int save(Telefonos t);
    public void eliminar(int id);
    public String generar_codigo();

}
