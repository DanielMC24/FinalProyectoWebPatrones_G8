package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Table(name="modalidad")
public class Modalidad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_modalidad")
    private long idModalidad; // transformar en id_categoria

    public long getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(long idModalidad) {
        this.idModalidad = idModalidad;
    }
    
        public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    private String descripcion;
//    @OneToMany
//    @JoinColumn(name = "id_categoria")
//    private List <Producto> productos;

    public Modalidad() {
    }

    public Modalidad(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
