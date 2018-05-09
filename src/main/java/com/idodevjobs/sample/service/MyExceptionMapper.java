package com.idodevjobs.sample.service;

import javax.ws.rs.ext.Provider;

import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Provider
@Produces(MediaType.APPLICATION_JSON)
public class MyExceptionMapper  {

    public Response toResponse(MyApplicationException e) {
        System.out.println("error:"); 
    	System.out.println(e.getMessage());
    	if (e.getMessage().equals("conversion de String a int")) {
    		return Response.status(Status.CONFLICT).build();
    	}else
    	if (e.getMessage().equals("Error de autenticacion")) {
    		return Response.status(Status.UNAUTHORIZED).build();
    	}else
    	if (e.getMessage().equals("Dato Duplicado")) {
    		return Response.status(Status.SERVICE_UNAVAILABLE).build();
    	}else
    	if (e.getMessage().equals("Error de base de datos")) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    	}else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
    	
//    	return Response.status(Status.NOT_FOUND).build();
    }

}

