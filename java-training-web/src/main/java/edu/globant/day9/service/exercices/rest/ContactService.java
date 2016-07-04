package edu.globant.day9.service.exercices.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.globant.day9.dao.hibernateimpl.ContactDaoImpl;
import edu.globant.day9.domain.Contact;
import edu.globant.day9.service.exercices.soap.dtos.ContactDTO;

@Path("/contacts")
public class ContactService {
	
	ContactDaoImpl contactDao;
	
	@POST
	public void saveContact(@FormParam(value = "contactDTO") ContactDTO contactDTO) {
		contactDao.save(ContactDTO.getContactFromContactDTO(contactDTO));
	}
	
	@PUT
	@Path("/{contactId}")
	public Response  updateContact(@PathParam("contactId") Long contactId,
			@FormParam(value = "contactDTO") ContactDTO contactDTO){
		Contact looked = contactDao.findById(contactId);
		if(looked==null) return Response.status(Response.Status.NOT_FOUND).entity(new ContactDTO()).build();
		Contact newData = ContactDTO.getContactFromContactDTO(contactDTO);
		looked = newData;
		contactDao.update(looked);
		return Response.ok(ContactDTO.getContactDTOFromContact(looked), MediaType.APPLICATION_JSON).build();
	}

}
