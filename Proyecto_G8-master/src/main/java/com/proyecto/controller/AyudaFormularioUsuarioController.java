/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.Service.TipoAyudaService;
import com.proyecto.domain.TipoAyuda;
import com.proyecto.Service.ModalidadService;
import com.proyecto.domain.Modalidad;
import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Usuario;
import com.proyecto.Service.AyudasFormularioService;
import com.proyecto.domain.Ayudas;
import com.proyecto.Service.SolicitudService;
import com.proyecto.domain.Solicitud;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/formularioAyuda")
@Slf4j
public class AyudaFormularioUsuarioController {
    
    @Autowired
    private AyudasFormularioService ayudasFormularioService;
    
    @Autowired
    private SolicitudService solicitudService;
    
    @Autowired
    private ModalidadService modalidadService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/formulario")
    public String page(Model model, HttpSession session) {
        List<Ayudas> ayudas = ayudasFormularioService.getAyudas();
        model.addAttribute("ayudas", ayudas);
        return "ayudasFormularioUsuario";
    }
    
    @GetMapping("/modificar/{idAyuda}")
    public String cargarDatosAyuda(Ayudas ayuda, Model model, HttpSession session) {
        List<Ayudas> ayudas = ayudasFormularioService.getAyudas();
        model.addAttribute("ayudas", ayudas);
        
        Modalidad modalidad = new Modalidad();
        Modalidad modalidad2 = new Modalidad();
        ayuda = ayudasFormularioService.getAyuda(ayuda);
        modalidad.setIdModalidad(Long.parseLong(ayuda.getId_modalidad()));
        modalidad2 = modalidadService.getModalidad(modalidad);
        
        ayuda.setId_modalidad(modalidad2.getDescripcion());
        model.addAttribute("ayudas", ayuda);
        //model.addAttribute("ayudas", ayudas);
        return "ayudasFormularioUsuarioCargarDatos";
    }
    
    @PostMapping("/guardar")
    public String solicitudGuardar(Ayudas ayuda, HttpSession session) {
        
        List<Usuario> usuarios = usuarioService.getUsuarios(true);
        String idUsuario = "";
        for(Usuario usuario : usuarios)
        {
            if(usuario.getCorreo_electronico().equals(session.getAttribute("Email")))
            {
                idUsuario = String.valueOf(usuario.getIdUsuario());
            }
            
        }
        
        Solicitud solicitud = new Solicitud();
        //solicitud.setId_usuario("1");
        solicitud.setId_usuario(idUsuario);
        solicitud.setEstado("2");
        long idAyuda = ayuda.getIdAyuda();
        String id = Long.toString(idAyuda);
        solicitud.setId_ayuda(id);
        System.out.println("ID " + id);
        solicitudService.save(solicitud);
        return "redirect:/datosEnviados";
    }
    
}
