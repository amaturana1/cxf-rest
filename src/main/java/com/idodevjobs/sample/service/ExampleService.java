package com.idodevjobs.sample.service;
 
import com.idodevjobs.sample.model.Contact;
import com.idodevjobs.sample.model.ExampleModel;
import com.idodevjobs.sample.model.RegistroContactoVO;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/*
 * Author: Andrés Maturana
 * Interface: ExampleService
 * La siguiente interface define los tipos de operaciones (POST, GET) 
 * en el servicio web REST, con sus respectivas rutas y datos específicos, 
 * lo que producen y consumen, en la clase ExampleServiceImpl se confirmará 
 * su implementación.
 * 
 * */ 
@Path("/example")//ruta rest que va en la url después del nombre del proyecto
@Produces("application/json")
public interface ExampleService {
 
    @GET
    @Path("/{id}")//dato que recibe la operación get en su url
    @Produces(MediaType.APPLICATION_JSON)
    public RegistroContactoVO get(@PathParam("id") String id);
    
    
    @POST//este método tiene las funcionalidades de recibir y devolver un archivo json
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("id")
    public Response post(RegistroContactoVO registroContactoVO) throws MyApplicationException;
    
}