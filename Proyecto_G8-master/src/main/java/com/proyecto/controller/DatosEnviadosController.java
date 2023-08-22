
package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DatosEnviadosController {
    
    @RequestMapping("/datosEnviados")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        //model.addAtrribute("rol", idRol);
        return "datosEnviados";
    }
    
    public String onClickAceptar()
    {
        return "MenuAyudasUsuario";
    }
}
