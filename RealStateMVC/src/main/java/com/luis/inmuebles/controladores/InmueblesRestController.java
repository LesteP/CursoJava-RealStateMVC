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

import com.luis.inmuebles.modelos.Inmueble;
import com.luis.inmuebles.repositorios.RepositorioInmuebles;



@Controller
@RequestMapping(value="/inmueble")
public class InmueblesRestController {

	@Autowired
	RepositorioInmuebles daoInmuebles;
	
    @RequestMapping	(method=RequestMethod.GET,value="/{id}")//crea la estructura de como quiero que lo reciba cuando pongamos /empleado/23 id valdra 23
	 public @ResponseBody Inmueble inmueble(@PathVariable int id){//recibimos los parametros el path variable es un parametro que viende desde la url @ResposeBody quier decir que responda con el mismo objeto que indica por ejemplo empleados
	  Inmueble i=daoInmuebles.get(Inmueble.class, id);//
	return i;  	
		
	      }
    @RequestMapping(method=RequestMethod.GET, value="/buscar/{texto}")
	public @ResponseBody List<Inmueble>buscar(@PathVariable String texto){

		if(texto.equals("NoBuscoNada"))
			texto="";

		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Inmueble> l=daoInmuebles.find("Inmueble.buscador", params);
		return l;


	}
    @RequestMapping(method=RequestMethod.GET, value="/buscarPrecio/{texto}")
	public @ResponseBody List<Inmueble>buscarPrecio(@PathVariable String texto){

		if(texto.equals("NoBuscoNada"))
			texto="";
		Double precioBuscar=Double.parseDouble(texto);
         
        Map<String, Object> params=new HashMap();
		params.put("precioBuscar", precioBuscar);
		List<Inmueble> l=daoInmuebles.find("Inmueble.buscadorPrecio", params);
		return l;


	}    
    @RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Inmueble inmueble){

		daoInmuebles.delete(inmueble);

		return "borrado";
	}



}








