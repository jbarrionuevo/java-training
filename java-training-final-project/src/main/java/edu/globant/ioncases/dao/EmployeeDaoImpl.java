/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.entity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedec
 */
public class EmployeeDaoImpl implements EmployeeDao{

    private List<Employee> employees = new ArrayList<Employee>();
    
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("addEmployee OK: " + employee.getFullname());
    }

    @Override
    public Employee getEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployee(int id) {
        return employees.get(id);
    }
    
}
