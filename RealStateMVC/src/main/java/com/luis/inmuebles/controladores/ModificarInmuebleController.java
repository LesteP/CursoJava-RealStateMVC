package com.luis.inmuebles.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.inmuebles.modelos.Inmueble;
import com.luis.inmuebles.modelos.viewforms.InmuebleViewForm;
import com.luis.inmuebles.repositorios.RepositorioInmuebles;
import com.luis.inmuebles.repositorios.RepositorioInquilinos;
import com.luis.inmuebles.repositorios.RepositorioPropietarios;



@Controller
@RequestMapping(value="modificarInmueble.html")
public class ModificarInmuebleController {
	@Autowired
	RepositorioInmuebles daoInmuebles;
	@Autowired
	RepositorioPropietarios daoPropietarios;
	@Autowired
	RepositorioInquilinos daoInquilinos;
	


	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap modelo,@PathVariable int id){
        Inmueble inmu=daoInmuebles.get(Inmueble.class, id);
		InmuebleViewForm inmueble=new InmuebleViewForm();
		inmueble.fromInmueble(inmu);
		modelo.addAttribute("inmueble", inmueble);

		Map<Integer,String> lp=daoPropietarios.getMapaOptions();
		Map<Integer,String> li=daoInquilinos.getMapaOptions();

		modelo.addAttribute("propietarios", lp);
		modelo.addAttribute("inquilinos",li);
		return "modificar";

	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("inmueble") InmuebleViewForm inmueble,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			Map<Integer,String> lp=daoPropietarios.getMapaOptions();
			Map<Integer,String> li=daoInquilinos.getMapaOptions();
			request.setAttribute("propietarios", lp);
			request.setAttribute("inquilinos",li);
			return "modificar";

		}
		Inmueble inmu=inmueble.getInmueble();
		daoInmuebles.update(inmu);

		return "redirect:/listado.html";
	}

}



