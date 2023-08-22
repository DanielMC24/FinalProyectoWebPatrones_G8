/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.Service.AyudasFormularioService;
import com.proyecto.Service.ModalidadService;
import com.proyecto.Service.TipoAyudaService;
import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Ayudas;
import com.proyecto.domain.Modalidad;
import com.proyecto.domain.TipoAyuda;
import com.proyecto.domain.Usuario;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/registroAyuda")
@Slf4j
public class AyudasFormularioInstitucionController {
    
@Autowired
    private TipoAyudaService tipoAyudaService;
    
    @Autowired
    private ModalidadService modalidadService;
    
    @Autowired
    private AyudasFormularioService ayudasFormularioService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/formulario")
    public String page(Model model, HttpSession session) {
        List<TipoAyuda> tiposAyudas = tipoAyudaService.getTiposAyudas();
        model.addAttribute("tiposAyudas", tiposAyudas);
        List<Modalidad> modalidades = modalidadService.getModalidades();
        model.addAttribute("modalidades", modalidades);
        return "ayudasFormularioInstitucion";
    }
    
    @PostMapping("/guardar")
    public String ayudasGuardar(Ayudas ayuda, HttpSession session) {
        List<Usuario> usuarios = usuarioService.getUsuarios(true);
        String idUsuario = "";
        for(Usuario usuario : usuarios)
        {
            if(usuario.getCorreo_electronico().equals(session.getAttribute("Email")))
            {
                idUsuario = String.valueOf(usuario.getIdUsuario());
            }
            
        }
        ayuda.setId_usuario(idUsuario);
        ayudasFormularioService.save(ayuda);
        return "redirect:/datosEnviados2";
    }
    
    
    
}
