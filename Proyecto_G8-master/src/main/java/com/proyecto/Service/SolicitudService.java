/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Service;

import com.proyecto.domain.Solicitud;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface SolicitudService {
        //Metodo para consultar las categorias. El parametro define si se muestran solo las activas o todas
    public List<Solicitud> getSolicitudes();
    
    // Se obtiene una categoria por su ID
    public Solicitud getSolicitud(Solicitud solicitud);
    
    //Insertar, se inserta cuando el id categoria esta vacio (valor 0 o null)
    //Modificar, se modifica cuando el id categoria no esta vacio
    public void save(Solicitud solicitud);
    
    
    //Se elimina un registro por su idCategoria
    public void delete(Solicitud solicitud);
}
