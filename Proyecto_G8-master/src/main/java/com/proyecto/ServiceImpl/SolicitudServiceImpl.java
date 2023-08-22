/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiceImpl;


import com.proyecto.domain.Solicitud;
import com.proyecto.Service.SolicitudService;
import com.proyecto.dao.SolicitudDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class SolicitudServiceImpl implements SolicitudService{
    
    @Autowired
    SolicitudDao solicitudDao;

    @Override
    @Transactional(readOnly = true)
    public List<Solicitud> getSolicitudes() {
        List<Solicitud> solicitudes = solicitudDao.findAll();
//
//        if (activos) {
//            categorias.removeIf(x -> !x.isActivo());
//        }

        return solicitudes;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Solicitud getSolicitud(Solicitud solicitud) {
        return solicitudDao.findById(solicitud.getIdSolicitud()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Solicitud solicitud) {
        solicitudDao.save(solicitud);
    }
    

    @Override
    @Transactional
    public void delete(Solicitud solicitud) {
        solicitudDao.delete(solicitud);
    }
    
}
