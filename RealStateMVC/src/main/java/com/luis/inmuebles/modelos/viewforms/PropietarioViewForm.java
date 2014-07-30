package com.luis.inmuebles.modelos.viewforms;

import com.luis.inmuebles.modelos.Propietario;

public class PropietarioViewForm {
	   private Integer idPropietario;
	   private String nombre;
	   private String dni;
	public PropietarioViewForm() {
		super();
	}
	public PropietarioViewForm(Integer idPropietario, String nombre, String dni) {
		super();
		this.idPropietario = idPropietario;
		this.nombre = nombre;
		this.dni = dni;
	}
	public Propietario getPropietario(){
		Propietario propi=new Propietario();
		propi.setIdPropietario(idPropietario);
		propi.setNombre(nombre);
		propi.setDni(dni);
		

	 return propi;
	}
	public void fromPropietario(Propietario propi){
		setIdPropietario(propi.getIdPropietario());
		setNombre(propi.getNombre());
		setDni(propi.getDni());

	}
	
	public Integer getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}




}
