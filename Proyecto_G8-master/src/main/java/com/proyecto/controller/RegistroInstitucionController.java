/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.Service.SectorService;
import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Sector;
import com.proyecto.domain.Usuario;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/registroInstitucion")
@Slf4j
public class RegistroInstitucionController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private SectorService sectorService;
    
    @GetMapping("/formulario")
    public String page(Model model) {
        List<Sector> sectores = sectorService.getSectores();
        model.addAttribute("sectores", sectores);
        return "registroInstitucion";
    }
    
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario, Model model) {
        log.info("Consumo del recurso /usuarios/guardar");
        String idRol = "2";
        usuario.setRol(idRol);
        usuarioService.save(usuario);
        model.addAttribute("rol", idRol);
        return "redirect:/login";
    }
    
}
