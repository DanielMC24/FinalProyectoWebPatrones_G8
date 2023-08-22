
package com.proyecto.controller;

import com.proyecto.Service.SectorService;
import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Sector;
import com.proyecto.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfilUsuarioModificar")
@Slf4j
public class PerfilUsuarioModificarController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private SectorService sectorService;
    
    @RequestMapping("/modificar")
    public String page(Model model, HttpSession session ) {
        List<Sector> sectores = sectorService.getSectores();
        model.addAttribute("sectores", sectores);
        
        List<Usuario> usuarios = usuarioService.getUsuarios(true);
        String idUsuario = "";
        Usuario usuario1 = new Usuario();
        for(Usuario usuario : usuarios)
        {
            if(usuario.getCorreo_electronico().equals(session.getAttribute("Email")))
            {
                idUsuario = String.valueOf(usuario.getIdUsuario());
            }
            
        }
        
        usuario1.setIdUsuario(Long.parseLong(idUsuario));
        usuario1 = usuarioService.getUsuario(usuario1);
        
        Sector sector = new Sector();
        sector.setIdSector(Long.parseLong(usuario1.getSector()));
        sector = sectorService.getSector(sector);
        usuario1.setSector(sector.getDescripcion());
        
        model.addAttribute("usuario", usuario1);
        return "perfilUsuarioEditar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Usuario usuario, HttpSession session ) {
        
        List<Usuario> usuarios = usuarioService.getUsuarios(true);
        String idUsuario = "";
        Usuario usuario1 = new Usuario();
        for(Usuario usuarioInfo : usuarios)
        {
            if(usuarioInfo.getCorreo_electronico().equals(session.getAttribute("Email")))
            {
                usuario1 = usuarioInfo;
            }
        }
        
        usuario1.setNombre(usuario.getNombre());
        usuario1.setContrasena(usuario.getContrasena());
        usuario1.setUbicacion(usuario.getUbicacion());
        usuario1.setCedula(usuario.getCedula());
        usuario1.setSector(usuario.getSector());
        usuarioService.save(usuario1);
        
        return "redirect:/perfilUsuario";
    }
    
}
