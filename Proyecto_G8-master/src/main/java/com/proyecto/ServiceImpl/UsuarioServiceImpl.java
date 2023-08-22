/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiceImpl;


import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Usuario;
import com.proyecto.Service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(boolean activos) {
        List<Usuario> categorias = usuarioDao.findAll();
//
//        if (activos) {
//            categorias.removeIf(x -> !x.isActivo());
//        }

        return categorias;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }
    

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
}
