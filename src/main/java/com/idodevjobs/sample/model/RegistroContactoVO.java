package com.idodevjobs.sample.model;

import java.util.List;

public class RegistroContactoVO {

	public RegistroContactoVO() {
	}

	public RegistroContactoVO(List<Contact> contactos) {
		this.contactos = contactos;
	}
	private List <Contact>contactos;

	public List<Contact> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contact> contactos) {
		this.contactos = contactos;
	}


	@Override
	public String toString() {
		return "RegistroContactoVO [contactos=" + contactos + "]";
	}
	
	
	
	
}
