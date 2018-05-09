package com.idodevjobs.sample.client;

import java.util.ArrayList;
import java.util.List;


import org.apache.cxf.jaxrs.client.WebClient;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.idodevjobs.sample.model.Contact;
import com.idodevjobs.sample.model.CorreosVO;
import com.idodevjobs.sample.model.ExampleModel;
import com.idodevjobs.sample.model.RegistroContactoVO;

import javax.ws.rs.core.Response;

/*
 * Author: Andrés Maturana
 * Class: ClienteRest
 * Clase main que genera un cliente encargado de consumir un servicio web rest
 * con cxf, utilizando las operaciones GET y POST
 * */

public class ClienteRest {

	public static void main(String[] args) {

			metodoPost();
		
	}
	
	public static void metodoGet() {
		
		
		
		List<Object> providers = new ArrayList<Object>();
		  providers.add(new JacksonJsonProvider());
		WebClient client = WebClient.create("http://localhost:8080/proyectoCXFRest-1.0/services/example/",providers);
		RegistroContactoVO registroContactos = client.accept("application/json").type("application/json").path(2).get(RegistroContactoVO.class);
		System.out.println(registroContactos);  

	}
	
	
	public static void metodoPost() {
		List<Object> providers = new ArrayList<Object>();
		  providers.add(new JacksonJsonProvider());
		  
		CorreosVO correo1=new CorreosVO("andress154@gmail.com","andres","gmail");
    	ArrayList<CorreosVO>listaDeCorreos=new ArrayList<CorreosVO>();
    	listaDeCorreos.add(correo1);
    	

    	ExampleModel exampleModel=new ExampleModel("EJEMPLO","EJEMPLO",123,"123",listaDeCorreos);
		
		Contact contact=new Contact("9","9","a","a","9");
		List<Contact>contactos=new ArrayList<>();
		contactos.add(contact);
		RegistroContactoVO registroContactoVO=new RegistroContactoVO(contactos);
		
		WebClient client = WebClient
		.create("http://localhost:8080/proyectoCXFRest-1.0/services/example/id", providers);
				  
		client = client.accept("application/json").type("application/json");
				  
		Response response = client.post(registroContactoVO);
		System.out.println("estadoRespuesta"+response.getStatus());
//		System.out.println("StatusInfo: "+response.getStatusInfo().getStatusCode());
//		System.out.println("StatusInfo: "+response.getStatusInfo().getReasonPhrase());
//		System.out.println("StatusInfo: "+response.getHeaders());
		
		
		if(response.getStatus()==200) {
			RegistroContactoVO reg = response.readEntity(RegistroContactoVO.class);
			System.out.println(reg);
		}else {
			System.out.println(response.readEntity(String.class));
		}
		
		

	}
	
	

}
