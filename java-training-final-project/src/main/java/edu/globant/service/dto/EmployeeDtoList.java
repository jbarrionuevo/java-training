package edu.globant.service.dto;

import java.util.List;

public class EmployeeDtoList {

	private List<EmployeeDto> employeeList;

	public List<EmployeeDto> getContactList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeDto> employeeList) {
		this.employeeList = employeeList;
	}
}
