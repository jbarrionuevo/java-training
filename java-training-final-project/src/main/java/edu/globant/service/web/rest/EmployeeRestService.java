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

import edu.globant.domain.Employee;
import edu.globant.service.dto.DtoMapper;
import edu.globant.service.dto.EmployeeDto;
import edu.globant.service.dto.EmployeeDtoList;
import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.service.employee.ListEmployeeService;
import edu.globant.service.factory.ServiceFactory;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRestService {

	@Context
    private HttpServletRequest request;

	DtoMapper mapper = new DtoMapper();

	public CreateEmployeeService getCreateEmployeeService() {
		ServiceFactory serviceFactory = (ServiceFactory)request.getAttribute("serviceFactory");
		return serviceFactory.createEmployeeService();
	}
	
	public ListEmployeeService getListEmployeeService() {
		ServiceFactory serviceFactory = (ServiceFactory)request.getAttribute("serviceFactory");
		return serviceFactory.listEmployeeService();
	}

	@GET
	public Response getAllEmployees() {
		List<Employee> employeeList = getListEmployeeService().findAll();
		List<EmployeeDto> contactDtoList = new ArrayList<>(employeeList.size());
		for (Employee employee : employeeList) {
			contactDtoList.add(mapper.getContactDto(employee));
		}
		EmployeeDtoList result = new EmployeeDtoList();
		result.setEmployeeList(contactDtoList);
		return Response.ok(result).build();
	}

	@GET
	@Path("{id}")
	public Response getContact(@PathParam("id") Long id) {
		return Response.ok(
				mapper.getContactDto(getListEmployeeService().findById(id))
				).build();
	}
}
