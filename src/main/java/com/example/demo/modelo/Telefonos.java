package com.example.demo.modelo;

import javax.persistence.*;

@Entity
@Table(name = "telefonos")


public class Telefonos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtelefono;
    private String tipo;
    private  Long numero;
    private String estado;
    public Telefonos(){

    }

    public Telefonos(int id, String tipo, Long numero, String estado) {
        super();
        this.idtelefono = id;
        this.tipo = tipo;
        this.numero = numero;
        this.estado = estado;
    }

    public void setId(int id) {
        this.idtelefono = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return idtelefono;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getEstado() {
        return estado;
    }

    public Long getNumero() {
        return numero;
    }
    
    public String getdes_estado() {
    	switch (this.getEstado()) {
    		case "1":
    			return "ACTIVO";
    		case "2":
    			return "INACTIVO";
    	}
    	return "IBNACTIVO";  
    }
}
