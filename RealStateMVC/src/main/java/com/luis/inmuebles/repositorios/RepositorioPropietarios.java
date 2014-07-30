package com.luis.inmuebles.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.inmuebles.modelos.Propietario;

public class RepositorioPropietarios extends Repositorio<Propietario> {

	public Map<Integer, String> getMapaOptions(){

		List<Propietario> l=get(Propietario.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();

		for (Propietario propietario : l) {

			mapa.put(propietario.getIdPropietario(),
					propietario.getNombre());
		}

		return mapa;
	}


}
