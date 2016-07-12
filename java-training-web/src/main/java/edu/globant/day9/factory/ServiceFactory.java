package edu.globant.day9.factory;

import edu.globant.day9.service.ContactDetailTypeService;
import edu.globant.day9.service.EmployeeService;

public interface ServiceFactory {

	EmployeeService createContactService();
	ContactDetailTypeService createContactDetailTypeService();
}
