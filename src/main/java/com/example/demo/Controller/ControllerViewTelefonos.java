package com.example.demo.Controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// Este controlador devuelve las vistas que se encuentran en la carpeta de recursos. Es decir
// el archivo html.

@Controller
public class ControllerViewTelefonos {
	
	@GetMapping("/vista_telefonos")
    public String index(Model model) {
    	 model.addAttribute("titulo", "Prueba");
    	 return "telefonos";
    }

	@GetMapping("/vista_tipo_telefono")
	public String indextipo(Model model){
		model.addAttribute("titulo2", "Prueba2");
		return "tipo_telefono";
	}

}
