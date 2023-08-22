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
@Table(name="tiposayuda")
public class TipoAyuda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tipo_ayuda")
    private long idTipoAyuda; // transformar en id_categoria

    public long getIdTipoAyuda() {
        return idTipoAyuda;
    }

    public void setIdTipoAyuda(long idTipoAyuda) {
        this.idTipoAyuda = idTipoAyuda;
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

    public TipoAyuda() {
    }

    public TipoAyuda(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
