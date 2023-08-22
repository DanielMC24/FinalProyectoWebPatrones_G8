
package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DatosEnviados2Controller {
    
    @RequestMapping("/datosEnviados2")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        //model.addAtrribute("rol", idRol);
        return "datosEnviados2";
    }
    
}
