/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.domain.Ayudas;
import com.proyecto.Service.AyudasFormularioService;
import com.proyecto.domain.Modalidad;
import com.proyecto.Service.ModalidadService;
import com.proyecto.Service.TipoAyudaService;
import com.proyecto.domain.TipoAyuda;
import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Usuario;
import com.proyecto.Service.SolicitudService;
import com.proyecto.domain.Solicitud;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/listadoSolicitudes")
@Slf4j
public class ListadoSolicitudes {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private SolicitudService solicitudService;
    
    @Autowired
    private AyudasFormularioService ayudasService;
    
    @RequestMapping("/consultar")
    public String page(Model model, HttpSession session) {
        List<Solicitud> solicitudes = solicitudService.getSolicitudes();
        List<Solicitud> solicitudes2 = new ArrayList<>();
        for(Solicitud solicitud : solicitudes)
        {
            //Traigo solo solicitudes pendientes
            if(solicitud.getEstado().equals("2"))
            {
                Ayudas ayuda1 = new Ayudas();
                Ayudas ayuda2 = new Ayudas();
                ayuda1.setIdAyuda(Long.parseLong(solicitud.getId_ayuda()));
                ayuda2 = ayudasService.getAyuda(ayuda1);
                solicitud.setId_ayuda(ayuda2.getDescripcion());
                
                Usuario usuario1 = new Usuario();
                usuario1.setIdUsuario(Long.parseLong(ayuda2.getId_usuario()));
                usuario1 = usuarioService.getUsuario(usuario1);
                
                //Traigo solo solicitudes pendientes de aprobar para el usuario conectado 
                if(usuario1.getCorreo_electronico().equals(session.getAttribute("Email")))
                {
                    usuario1 = new Usuario();
                    Usuario usuario2 = new Usuario();
                    usuario1.setIdUsuario(Long.parseLong(solicitud.getId_usuario()));
                    usuario2 = usuarioService.getUsuario(usuario1);
                    solicitud.setId_usuario(usuario2.getNombre());
                    solicitudes2.add(solicitud);
                }
            }
            

            
        }
        model.addAttribute("solicitudes", solicitudes2);
        return "listadoSolicitudes";
    }
    
    @GetMapping("/aprobar/{idSolicitud}")
    public String aprobarSolicitud(@PathVariable(value="idSolicitud") String id, Model model, HttpSession session) {
        
        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(Long.parseLong(id));
        solicitud = solicitudService.getSolicitud(solicitud);
        solicitud.setEstado("3");
        solicitudService.save(solicitud);
        return "redirect:/listadoSolicitudes/consultar";
    }
    
    @GetMapping("/rechazar/{idSolicitud}")
    public String rechazarSolicitud(@PathVariable(value="idSolicitud") String id, Model model, HttpSession session) {
        
        Solicitud solicitud = new Solicitud();
        solicitud.setIdSolicitud(Long.parseLong(id));
        solicitud = solicitudService.getSolicitud(solicitud);
        solicitud.setEstado("4");
        solicitudService.save(solicitud);
        return "redirect:/listadoSolicitudes/consultar";
    }
    
}
