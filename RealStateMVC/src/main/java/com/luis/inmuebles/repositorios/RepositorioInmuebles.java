package com.luis.inmuebles.repositorios;

import org.hibernate.Hibernate;

import com.luis.inmuebles.modelos.Inmueble;

public class RepositorioInmuebles extends Repositorio<Inmueble> {
	@Override
	public Inmueble get(Class<Inmueble> tipo, int id) {
		// TODO Auto-generated method stub
		Inmueble i= super.get(tipo, id);

		Hibernate.initialize(i.getInquilino());
		Hibernate.initialize(i.getPropietario());
		

		return i;
	}
}
