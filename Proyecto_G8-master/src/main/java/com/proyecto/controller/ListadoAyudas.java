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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/listadoAyudas")
@Slf4j
public class ListadoAyudas {
    
    @Autowired
    private AyudasFormularioService ayudasService;
    @Autowired
    private ModalidadService modalidadService;
    @Autowired
    private TipoAyudaService tipoAyudaService;
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping("/consultar")
    public String page(Model model, HttpSession session) {
        List<Ayudas> ayudas = ayudasService.getAyudas();
        List<Ayudas> ayudasTabla = new ArrayList<Ayudas>();
        for(Ayudas ayuda : ayudas)
        {
            Modalidad modalidad = new Modalidad();
            Modalidad modalidad2 = new Modalidad();
            modalidad.setIdModalidad(Long.parseLong(ayuda.getId_modalidad()));
            modalidad2 = modalidadService.getModalidad(modalidad);
            ayuda.setId_modalidad(modalidad2.getDescripcion());
            
            TipoAyuda tipoAyuda1 = new TipoAyuda();
            TipoAyuda tipoAyuda2 = new TipoAyuda();
            tipoAyuda1.setIdTipoAyuda(Long.parseLong(ayuda.getId_tipo_ayuda()));
            tipoAyuda2 = tipoAyudaService.getTipoAyuda(tipoAyuda1);
            ayuda.setId_tipo_ayuda(tipoAyuda2.getDescripcion());
            
            Usuario usuario1 = new Usuario();
            usuario1.setIdUsuario(Long.parseLong(ayuda.getId_usuario()));
            
            usuario1 = usuarioService.getUsuario(usuario1);
                
                //Traigo solo solicitudes pendientes de aprobar para el usuario conectado 
                if(usuario1.getCorreo_electronico().equals(session.getAttribute("Email")))
                {
                    usuario1 = new Usuario();
                    Usuario usuario2 = new Usuario();
                    usuario1.setIdUsuario(Long.parseLong(ayuda.getId_usuario()));
                    usuario2 = usuarioService.getUsuario(usuario1);
                    ayuda.setId_usuario(usuario2.getNombre());
                    ayudasTabla.add(ayuda);
                }
            
            
        }
        model.addAttribute("ayudas", ayudasTabla);
        return "listadoAyudas";
    }
    
}
