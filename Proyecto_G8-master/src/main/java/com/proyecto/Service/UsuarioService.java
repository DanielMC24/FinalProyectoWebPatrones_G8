/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Service;

import com.proyecto.domain.Usuario;
import java.util.List;


/**
 *
 * @author Usuario
 */
public interface UsuarioService {
    //Metodo para consultar las categorias. El parametro define si se muestran solo las activas o todas
    public List<Usuario> getUsuarios(boolean activos);
    
    // Se obtiene una categoria por su ID
    public Usuario getUsuario(Usuario usuario);
    
    //Insertar, se inserta cuando el id categoria esta vacio (valor 0 o null)
    //Modificar, se modifica cuando el id categoria no esta vacio
    public void save(Usuario usuario);
    
    
    //Se elimina un registro por su idCategoria
    public void delete(Usuario usuario);
    
}
