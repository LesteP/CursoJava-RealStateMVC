package com.luis.inmuebles.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.inmuebles.modelos.Inquilino;

public class RepositorioInquilinos extends Repositorio<Inquilino>{

	public Map<Integer, String> getMapaOptions(){

		List<Inquilino> l=get(Inquilino.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();

		for (Inquilino inquilino : l) {

			mapa.put(inquilino.getIdInquilino(),
					inquilino.getNombre());
		}

		return mapa;
	}
	
}
