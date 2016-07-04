package edu.globant.service.dto;

import edu.globant.domain.Employee;

public class DtoMapper {
	public EmployeeDto getContactDto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setType(employee.getType());

		return dto;
	}
}
