package com.idodevjobs.sample.model;

/*
 * Author: Andrés Maturana
 * Class: CorreosVO
 * Esta clase contendrá los datos de los correos de la persona
 * 
 * */
public class CorreosVO {

	private String correoCompleto;
	private String nombreUsuario;
	private String empresa;
	
	public CorreosVO() {
	}
	public CorreosVO(String correoCompleto, String nombreUsuario, String empresa) {
		super();
		this.correoCompleto = correoCompleto;
		this.nombreUsuario = nombreUsuario;
		this.empresa = empresa;
	}
	public String getCorreoCompleto() {
		return correoCompleto;
	}
	public void setCorreoCompleto(String correoCompleto) {
		this.correoCompleto = correoCompleto;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	@Override
	public String toString() {
		return "CorreosVO [correoCompleto=" + correoCompleto + ", nombreUsuario=" + nombreUsuario + ", empresa="
				+ empresa + "]";
	}
	
	
	
}
