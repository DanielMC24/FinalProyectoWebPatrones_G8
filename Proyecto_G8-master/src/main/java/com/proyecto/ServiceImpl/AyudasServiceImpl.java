/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiceImpl;


import com.proyecto.domain.Ayudas;
import com.proyecto.Service.AyudasFormularioService;
import com.proyecto.dao.AyudasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class AyudasServiceImpl implements AyudasFormularioService{
    
    @Autowired
    AyudasDao ayudasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ayudas> getAyudas() {
        List<Ayudas> categorias = ayudasDao.findAll();
//
//        if (activos) {
//            categorias.removeIf(x -> !x.isActivo());
//        }

        return categorias;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Ayudas getAyuda(Ayudas usuario) {
        return ayudasDao.findById(usuario.getIdAyuda()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Ayudas usuario) {
        ayudasDao.save(usuario);
    }
    

    @Override
    @Transactional
    public void delete(Ayudas usuario) {
        ayudasDao.delete(usuario);
    }
    
}
