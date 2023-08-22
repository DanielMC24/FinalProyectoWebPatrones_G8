/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Usuario;
import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Sector;
import com.proyecto.Service.SectorService;
import java.util.HashSet;
//import com.proyecto.Service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/registroUsuario")
@Slf4j
public class RegistroUsuarioController {
    
     @Autowired
    private UsuarioService usuarioService;
     
    @Autowired
    private SectorService sectorService;
     


//    @Autowired
//    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/formulario")
    public String page(Model model) {
//        log.info("Consumo del recurso /usuarios/formulario");
//        List<Usuario> usuarios = usuarioService.getUsuarios(false);
//        model.addAttribute("usuarios", usuarios);
//        model.addAttribute("totalusuarios", usuarios.size());

        List<Sector> sectores = sectorService.getSectores();
        model.addAttribute("sectores", sectores);
        return "registroUsuario";
    }
    
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario) {
        log.info("Consumo del recurso /usuarios/guardar");
        String idRol = "1";
        usuario.setRol(idRol);
        usuarioService.save(usuario);
        return "redirect:/login_1";
    }
    
}
