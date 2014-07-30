package com.luis.inmuebles.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.inmuebles.modelos.Propietario;
import com.luis.inmuebles.modelos.viewforms.PropietarioViewForm;
import com.luis.inmuebles.repositorios.RepositorioPropietarios;




@Controller
@RequestMapping(value="altaPropietario.html")
public class PropietariosAltaController {
	
	@Autowired
	RepositorioPropietarios daoPropietarios;
	
	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){

		PropietarioViewForm propietario=new PropietarioViewForm();
		modelo.addAttribute("propietario", propietario);

		return "altaPropietario";

	}
	@RequestMapping(method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("propietario") PropietarioViewForm propietario,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			
			return "altaPropietario";

		}
		Propietario propi=propietario.getPropietario();
		daoPropietarios.add(propi);

		return "redirect:/listadoPropietario.html";
	}

}
 










