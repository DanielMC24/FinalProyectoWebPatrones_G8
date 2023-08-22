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
@Table(name="solicitud")
public class Solicitud implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_solicitud")
    private long idSolicitud; // transformar en id_categoria

    public long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    


    public String getId_ayuda() {
        return id_ayuda;
    }

    public void setId_ayuda(String id_ayuda) {
        this.id_ayuda = id_ayuda;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String id_ayuda;
    private String id_usuario;
    private String estado;

    
//    @OneToMany
//    @JoinColumn(name = "id_categoria")
//    private List <Producto> productos;

    public Solicitud() {
    }

    public Solicitud(String id_usuario, String id_ayuda,  String estado) {
        this.id_ayuda = id_ayuda;
        this.id_usuario = id_usuario;
        this.estado = estado;
    }


    
}
