package com.example.demo.service;

import com.example.demo.interfaceService.ITelefonoService;
import com.example.demo.interfaces.ITelefonos;
import com.example.demo.modelo.Telefonos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelofonoService implements ITelefonoService {

    @Autowired
    private ITelefonos data;

    @Override
    public List<Telefonos> listar() {
        return (List<Telefonos>) data.findAll();
    }

    @Override
    public Optional<Telefonos> listarid(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Telefonos t) {
    	int res = 0;
    	Telefonos telefono = data.save(t);
    	if (telefono != null) {
    		res = 1;
    	}
        return res;
    }

    @Override
    public void eliminar(int id) {
		data.deleteById(id);
    }

	@Override
	public String generar_codigo() {
		// TODO Auto-generated method stub
		return null;
	}
}
