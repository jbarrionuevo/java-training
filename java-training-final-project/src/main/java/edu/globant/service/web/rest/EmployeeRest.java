package edu.globant.service.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import edu.globant.day10.dto.ContactDto;
//import edu.globant.day10.dto.ContactDtoList;
//import edu.globant.day10.mapper.Mapper;
//import edu.globant.day9.domain.Contact;
//import edu.globant.day9.factory.ServiceFactory;
//import edu.globant.day9.service.ContactService;
import edu.globant.service.employee.ListEmployeeService;
import edu.globant.service.factory.ServiceFactory;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRest {

	@Context
    private HttpServletRequest request;

	//Mapper mapper = new Mapper();

	public ListEmployeeService getListEmployeeService() {
		ServiceFactory serviceFactory = (ServiceFactory)request.getAttribute("serviceFactory");
		return serviceFactory.listEmployeeService();
	}

	@GET
	public Response getAllEmployees() {
//		List<Contact> contactList = getContactService().findAll();
//		List<ContactDto> contactDtoList = new ArrayList<>(contactList.size());
//		for (Contact contact : contactList) {
//			contactDtoList.add(mapper.getContactDto(contact));
//		}
//		ContactDtoList result = new ContactDtoList();
//		result.setContactList(contactDtoList);
//		return Response.ok(result).build();
		System.out.println("**************************FUNCIONA getAllEmployees *********************************");
		return Response.ok("*****getAllEmployees****").build();
	}

//	@GET
//	@Path("{id}")
//	public Response getContact(@PathParam("id") Long id) {
//		return Response.ok(
//				mapper.getContactDto(getContactService().findById(id))
//				).build();
//	}
}
