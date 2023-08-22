/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiceImpl;


import com.proyecto.dao.ModalidadDao;
import com.proyecto.domain.Modalidad;
import com.proyecto.Service.ModalidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class ModalidadServiceImpl implements ModalidadService{
    
    @Autowired
    ModalidadDao modalidadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Modalidad> getModalidades() {
        List<Modalidad> sectores = modalidadDao.findAll();
        return sectores;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Modalidad getModalidad(Modalidad modalidad) {
        return modalidadDao.findById(modalidad.getIdModalidad()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Modalidad modalidad) {
        modalidadDao.save(modalidad);
    }
    

    @Override
    @Transactional
    public void delete(Modalidad modalidad) {
        modalidadDao.delete(modalidad);
    }
    
}
