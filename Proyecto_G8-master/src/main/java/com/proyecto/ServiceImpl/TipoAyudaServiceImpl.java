/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiceImpl;


import com.proyecto.dao.TipoAyudaDao;
import com.proyecto.domain.TipoAyuda;
import com.proyecto.Service.TipoAyudaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class TipoAyudaServiceImpl implements TipoAyudaService{
    
    @Autowired
    TipoAyudaDao tipoAyudaDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoAyuda> getTiposAyudas() {
        List<TipoAyuda> tiposAyudas = tipoAyudaDao.findAll();
        return tiposAyudas;
    }
    
    @Override
    @Transactional(readOnly = true)
    public TipoAyuda getTipoAyuda(TipoAyuda tipoAyuda) {
        return tipoAyudaDao.findById(tipoAyuda.getIdTipoAyuda()).orElse(null);
    }

    @Override
    @Transactional
    public void save(TipoAyuda tipoAyuda) {
        tipoAyudaDao.save(tipoAyuda);
    }
    

    @Override
    @Transactional
    public void delete(TipoAyuda tipoAyuda) {
        tipoAyudaDao.delete(tipoAyuda);
    }
    
}
