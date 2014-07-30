package com.luis.inmuebles.modelos.viewforms;

import com.luis.inmuebles.modelos.Inmueble;
import com.luis.inmuebles.modelos.Inquilino;
import com.luis.inmuebles.modelos.Propietario;

public class InmuebleViewForm {
	private Integer idInmueble;
	private String direccion;
	private Double precio;
	private Integer idPropietario;
	private Integer idInquilino;
	public InmuebleViewForm() {
		super();
	}
	public InmuebleViewForm(Integer idInmueble, String direccion,
			Double precio, Integer idPropietario, Integer idInquilino) {
		super();
		this.idInmueble = idInmueble;
		this.direccion = direccion;
		this.precio = precio;
		this.idPropietario = idPropietario;
		this.idInquilino = idInquilino;
	}
	
	public Inmueble getInmueble(){
		Inmueble inmu=new Inmueble();
		inmu.setIdInmueble(idInmueble);
		inmu.setDireccion(direccion);
		inmu.setPrecio(precio);
		Propietario p=new Propietario();
		p.setIdPropietario(idPropietario);
		inmu.setPropietario(p);
		Inquilino i=new Inquilino();
		i.setIdInquilino(idInquilino);
		inmu.setInquilino(i);

     return inmu;
	}
    
	public void fromInmueble(Inmueble inmu){
		setIdInmueble(inmu.getIdInmueble());
		setDireccion(inmu.getDireccion());
		setPrecio(inmu.getPrecio());
		setIdPropietario(inmu.getPropietario().getIdPropietario());
		setIdInquilino(inmu.getInquilino().getIdInquilino());

		

	}
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}
	public Integer getIdInquilino() {
		return idInquilino;
	}
	public void setIdInquilino(Integer idInquilino) {
		this.idInquilino = idInquilino;
	}



}
