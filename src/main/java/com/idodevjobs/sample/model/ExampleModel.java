package com.idodevjobs.sample.model;

import java.util.ArrayList;

/*
 * Author: Andrés Maturana
 * Class: ExampleModel
 * Esta clase se encarga de almacenar un objeto virtual con los 
 * datos de una persona, incluye un arrayList 
 * con todos los correos asociados. 
 * 
 * */


public class ExampleModel {
	private String name_persona;
	private String nombre;
    private int telefono;
    private String rut;
    private ArrayList<CorreosVO> listaDeCorreos;
    
   

	public ExampleModel() {
	}
    
    public ExampleModel(String name_persona,String nombre, int telefono, String rut,ArrayList<CorreosVO>listaDeCorreos ) {
    	this.name_persona=name_persona;
    	this.nombre = nombre;
		this.telefono = telefono;
		this.rut = rut;
		this.listaDeCorreos=listaDeCorreos;
	}

    public ExampleModel(String name_persona,String nombre, int telefono, String rut ) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.rut = rut;
		this.name_persona=name_persona;
	}
    
    
    public String getname_persona() {
		return name_persona;
	}

	public void setname_persona(String name_persona) {
		this.name_persona = name_persona;
	}
    
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public ArrayList<CorreosVO> getListaDeCorreos() {
		return this.listaDeCorreos;
	}

	public void setListaDeCorreos(ArrayList<CorreosVO> listaDeCorreos) {
		this.listaDeCorreos = listaDeCorreos;
	}

	@Override
	public String toString() {
		return "ExampleModel [name_persona=" + name_persona + ", nombre=" + nombre + ", telefono=" + telefono + ", rut="
				+ rut + ", listaDeCorreos=" + listaDeCorreos + "]";
	}


	
}