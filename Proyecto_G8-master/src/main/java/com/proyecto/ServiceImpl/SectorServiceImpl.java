/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.ServiceImpl;


import com.proyecto.dao.SectorDao;
import com.proyecto.domain.Sector;
import com.proyecto.Service.SectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class SectorServiceImpl implements SectorService{
    
    @Autowired
    SectorDao sectorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Sector> getSectores() {
        List<Sector> sectores = sectorDao.findAll();
//
//        if (activos) {
//            categorias.removeIf(x -> !x.isActivo());
//        }

        return sectores;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Sector getSector(Sector sector) {
        return sectorDao.findById(sector.getIdSector()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Sector sector) {
        sectorDao.save(sector);
    }
    

    @Override
    @Transactional
    public void delete(Sector sector) {
        sectorDao.delete(sector);
    }
    
}
