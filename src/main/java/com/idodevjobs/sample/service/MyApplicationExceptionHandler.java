package com.idodevjobs.sample.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

 
@Provider
public class MyApplicationExceptionHandler implements ExceptionMapper<MyApplicationException>
{
    @Override
    public Response toResponse(MyApplicationException exception)
    {
//    	return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    	System.out.println(exception.getMessage());
    	if (exception.getMessage().equals("conversion de String a int")) {
    		return Response.status(Status.CONFLICT).entity(exception.getMessage()).build();
    	}else
    	if (exception.getMessage().equals("Error de autenticacion")) {
    		return Response.status(Status.UNAUTHORIZED).entity(exception.getMessage()).build();
    	}else
    	if (exception.getMessage().equals("Dato Duplicado")) {
    		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    	}else
    	if (exception.getMessage().equals("Error de base de datos")) {
    		return Response.status(Status.METHOD_NOT_ALLOWED).entity(exception.getMessage()).build();
    	}else {
    		return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();
    	}
    }
}