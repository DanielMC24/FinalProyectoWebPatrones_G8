/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */


@Entity
@Table(name="ayudas")
public class Ayudas implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ayuda")
    private long idAyuda; // transformar en id_categoria

    public long getIdAyuda() {
        return idAyuda;
    }

    public void setIdAyuda(long idAyuda) {
        this.idAyuda = idAyuda;
    }

    public String getId_tipo_ayuda() {
        return id_tipo_ayuda;
    }

    public void setId_tipo_ayuda(String id_tipo_ayuda) {
        this.id_tipo_ayuda = id_tipo_ayuda;
    }

    public String getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(String id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private String id_tipo_ayuda;
    private String id_modalidad;
    private String id_usuario;
    private String ubicacion;
    private String fecha;
    private String descripcion; 

    
//    @OneToMany
//    @JoinColumn(name = "id_categoria")
//    private List <Producto> productos;

    public Ayudas() {
    }

    public Ayudas(String id_tipo_ayuda, String id_modalidad, String id_usuario, String fecha, String ubicacion, String descripcion) {
    this.id_tipo_ayuda = id_tipo_ayuda;
    this.id_modalidad = id_modalidad;
    this.id_usuario = id_usuario;
    this.ubicacion = ubicacion;
    this.fecha = fecha;
    this.descripcion = descripcion;
    }
    
}
