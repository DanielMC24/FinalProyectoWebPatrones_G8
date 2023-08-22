/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.Service.UsuarioService;
import com.proyecto.domain.Usuario;
import com.proyecto.dao.UsuarioDao;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class LoginController1 {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    UsuarioDao usuarioDao;
    
    
    @RequestMapping("/login_1")
    public String page(Model model, HttpSession httpSession) {
        model.addAttribute("attribute", "value");
        return "login_1";
    }
    
    @PostMapping("/login")
    public String login(Usuario usuario, HttpSession httpSession) {

//        Usuario usuarioL = usuarioDao.findByUsernameAndPassword(usuario.getCorreo_electronico(), usuario.getContrasena());
//
//        httpSession.setAttribute("IDUsuario", usuarioL.getIdUsuario());
//       
//        usuarioService.getUsuarioPorUsernameYPassword(usuario.getCorreo_electronico(), usuario.getContrasena());
        
               // Obtener usuario loggeado
//       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       
//       UserDetails user = null;
//       
//       if (principal instanceof UserDetails){
//       
//           Usuario usuario = usuarioDao.findByUsername(user.getUsername());
//           
//           httpSession.setAttribute("Email", usuario.getCorreo());
//       }
        
        return "redirect:/login_1";
    }
    
}
