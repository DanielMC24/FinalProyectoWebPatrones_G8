/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.Service;

import com.proyecto.domain.Ayudas;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface AyudasFormularioService {
        //Metodo para consultar las categorias. El parametro define si se muestran solo las activas o todas
    public List<Ayudas> getAyudas();
    
    // Se obtiene una categoria por su ID
    public Ayudas getAyuda(Ayudas ayuda);
    
    //Insertar, se inserta cuando el id categoria esta vacio (valor 0 o null)
    //Modificar, se modifica cuando el id categoria no esta vacio
    public void save(Ayudas ayuda);
    
    
    //Se elimina un registro por su idCategoria
    public void delete(Ayudas ayuda);
}
