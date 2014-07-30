package com.luis.inmuebles.modelos.viewforms;

import com.luis.inmuebles.modelos.Inquilino;

public class InquilinoViewForm {
	private Integer idInquilino;
	   private String dni;
	   private String nombre;
	   private Integer edad;
	   private boolean trabaja;
	public InquilinoViewForm() {
		super();
	}
	public InquilinoViewForm(Integer idInquilino, String dni, String nombre,
			Integer edad, boolean trabaja) {
		super();
		this.idInquilino = idInquilino;
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.trabaja = trabaja;
	}
	public Inquilino getInquilino(){
		Inquilino inqui=new Inquilino();
		inqui.setIdInquilino(idInquilino);
		inqui.setDni(dni);
		inqui.setNombre(nombre);
		inqui.setEdad(edad);
		inqui.setTrabaja(trabaja);
		

	 return inqui;
	}
	public void fromInquilino(Inquilino inqui){
		setIdInquilino(inqui.getIdInquilino());
		setDni(inqui.getDni());
		setNombre(inqui.getNombre());
		setEdad(inqui.getEdad());
		setTrabaja(inqui.getTrabaja());

	}
	
	public Integer getIdInquilino() {
		return idInquilino;
	}
	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public boolean isTrabaja() {
		return trabaja;
	}
	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}
	   
}
