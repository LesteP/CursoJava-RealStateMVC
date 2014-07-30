package com.luis.inmuebles.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luis.inmuebles.modelos.Propietario;
import com.luis.inmuebles.repositorios.RepositorioPropietarios;


@Controller
@RequestMapping(value="/propietario")
public class PropietariosRestController {

	@Autowired
	RepositorioPropietarios daoPropietarios;
	
    @RequestMapping	(method=RequestMethod.GET,value="/{id}")
	 public @ResponseBody Propietario propietario(@PathVariable int id){
	  Propietario p=daoPropietarios.get(Propietario.class, id);
	return p;  	

	      }
    @RequestMapping(method=RequestMethod.GET, value="/buscar/{texto}")
	public @ResponseBody List<Propietario>buscar(@PathVariable String texto){

		if(texto.equals("NoBuscoNada"))
			texto="";

		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Propietario> l=daoPropietarios.find("Propietario.buscador", params);
		return l;


	}
    
    @RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Propietario propietario){

		daoPropietarios.delete(propietario);

		return "borrado";
	}



}







