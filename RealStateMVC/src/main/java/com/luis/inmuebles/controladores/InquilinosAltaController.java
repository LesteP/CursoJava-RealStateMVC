package com.luis.inmuebles.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.inmuebles.modelos.Inquilino;
import com.luis.inmuebles.modelos.viewforms.InquilinoViewForm;
import com.luis.inmuebles.repositorios.RepositorioInquilinos;






@Controller
@RequestMapping(value="altaInquilino.html")
public class InquilinosAltaController {
	@Autowired
	RepositorioInquilinos daoInquilinos;
	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){

		InquilinoViewForm inquilino=new InquilinoViewForm();
		modelo.addAttribute("inquilino", inquilino);

		return "altaInquilino";

	}
	@RequestMapping(method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("inquilino") InquilinoViewForm inquilino,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			
			return "altaInquilino";

		}
		Inquilino inqui=inquilino.getInquilino();
		daoInquilinos.add(inqui);

		return "redirect:/listadoInquilino.html";
	}

}
 










