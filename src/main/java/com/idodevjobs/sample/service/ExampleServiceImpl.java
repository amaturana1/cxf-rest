package com.idodevjobs.sample.service;
 
import com.idodevjobs.sample.model.CorreosVO;
import com.idodevjobs.sample.model.ExampleModel;
import com.idodevjobs.sample.model.RegistroContactoVO;
import com.idodevjobs.sample.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
/*
 * Author: Andrés Maturana
 * Clase: ExampleServiceImpl
 * Clase que implementa las operaciones correspondientes al webService ExampleService.
 * Contiene un método get y uno post, en los cuales se maneja el objeto virtual ExpampleModel 
 * 
 * */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
 
    @Override
    public RegistroContactoVO get(String modelId) {
    	SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		try {
			dataSource.setDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setUrl("jdbc:mysql://localhost/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("asdqwe123");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sqlSelect = "SELECT * FROM contact";
		List<Contact> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Contact>() {

			public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
				Contact contact = new Contact();
				contact.setName(result.getString("name"));
				contact.setEmail(result.getString("email"));
				contact.setAddress(result.getString("address"));
				contact.setPhone(result.getString("telephone"));
				
				return contact;
			}
			
		});
		for (Contact aContact : listContact) {
			System.out.println(aContact);
		}
    	
    	CorreosVO correo1=new CorreosVO("andress154@gmail.com","andres","gmail");
    	
    	System.out.println("modelId:"+modelId);
    	ArrayList<CorreosVO>listaDeCorreos=new ArrayList<CorreosVO>();
    	listaDeCorreos.add(correo1);
    	
//    	return new ExampleModel("andres","andres", 988904961,"18116556-1",listaDeCorreos);
    	return new RegistroContactoVO(listContact);
    }
    
    
    
    @Override
    public Response post(RegistroContactoVO registroContactoVO) throws MyApplicationException {

    	if(registroContactoVO == null)
		{
			throw new MyApplicationException("id is not present in request !!");
		}
    	//Validate proper format
        try
        {

//        	Integer.parseInt(registroContactoVO.getContactos().get(0).getAddress());
        	SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    		try {
    			dataSource.setDriver(new com.mysql.jdbc.Driver());
    		
        	dataSource.setUrl("jdbc:mysql://localhost/contactdb");
    		dataSource.setUsername("root");
    		dataSource.setPassword("asdqwe123");
    		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    		String sqlInsert = "INSERT INTO contact "
    						+ "(contact_id ,name, email, address, telephone)"
    				+ " VALUES ('"+registroContactoVO.getContactos().get(0).getContactId()+"', "
    						+ "'"+registroContactoVO.getContactos().get(0).getName()+"', "
    						+ "'"+registroContactoVO.getContactos().get(0).getEmail()+"', "
    						+ "'"+registroContactoVO.getContactos().get(0).getAddress()+"', "
    						+ "'"+registroContactoVO.getContactos().get(0).getPhone()+"')";
    		System.out.println(sqlInsert);
    		
    		
    		try {
    			try {
    			jdbcTemplate.update(sqlInsert);
    			}catch (CannotGetJdbcConnectionException e) {
    				throw new MyApplicationException("Error de autenticacion",e) ;
				}
    		}catch (DuplicateKeyException e) {
    			throw new MyApplicationException("Dato Duplicado",e) ;
			}
    		
    		} catch (SQLException e) {
    			throw new MyApplicationException("Error de base de datos",e) ;
    		}
        	return Response.ok().entity( registroContactoVO).build();
        }
        catch(NumberFormatException e)
        {
        	throw new MyApplicationException("conversion de String a int",e) ;
        }
    	
    }
    
    
//    	return new ExampleModel( "andres","andres", 988904961,"18116556-1");
//    	http://localhost:8080/proyectoCXFRest-1.0/services/example/id
//    	{
//    	    "name_persona": "andres",
//    	    "nombre": "andres",
//    	    "telefono": "988904961",
//    	    "rut": "18116556-1"
//    	}
    
}