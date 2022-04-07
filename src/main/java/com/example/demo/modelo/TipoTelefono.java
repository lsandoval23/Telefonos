package com.example.demo.modelo;

import javax.persistence.*;

@Entity
@Table(name = "tipo_telefono")
public class TipoTelefono {

    /** Atributos */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idTipo;

    @Column(name = "Nombre")
    private String nombre;

    /** Getters and setters */

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
