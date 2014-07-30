package com.luis.inmuebles.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.inmuebles.modelos.Inmueble;
import com.luis.inmuebles.repositorios.RepositorioInmuebles;




@Controller
public class InmueblesController {
	@Autowired //conectado automaticamente y vamos al xml y busca repositorio empleados y esta indicado que es el daoempleado
	RepositorioInmuebles daoInmuebles;
	
	@RequestMapping(value="/listado.html")
     public String Listado(Model modelo){
    	
		List<Inmueble> l=daoInmuebles.get(Inmueble.class);//vas a crear una lista utiliando los datos del get
		modelo.addAttribute("inmuebles", l);//objeto del spring para mantener los datos en la memoria coje datos desde la vista al controlador y del controlador a la vista
		
		return "listado";
     }
	@RequestMapping(value="detalle.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){

		int id=Integer.parseInt(request.getParameter("id"));

		Inmueble i=daoInmuebles.get(Inmueble.class, id);



		modelo.addAttribute("inmueble", i);

		return "detalle";
	}






}



