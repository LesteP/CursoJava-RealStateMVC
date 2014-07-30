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

import com.luis.inmuebles.modelos.Inquilino;
import com.luis.inmuebles.repositorios.RepositorioInquilinos;






@Controller
@RequestMapping(value="/inquilino")
public class InquilinosRestController {
	@Autowired
	RepositorioInquilinos daoInquilinos;
	
    @RequestMapping	(method=RequestMethod.GET,value="/{id}")
	 public @ResponseBody Inquilino inquilino(@PathVariable int id){
    	
    	Inquilino i=daoInquilinos.get(Inquilino.class, id);
    	return i;  	

	      }
    @RequestMapping(method=RequestMethod.GET, value="/buscar/{texto}")
	public @ResponseBody List<Inquilino>buscar(@PathVariable String texto){

		if(texto.equals("NoBuscoNada"))
			texto="";

		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Inquilino> l=daoInquilinos.find("Inquilino.buscador", params);
		return l;


	}
    
    @RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inquilino inquilino){

		daoInquilinos.delete(inquilino);

		return "borrado";
	}



}







