/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Service;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.EmployeeDao;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.EmployeeDaoImpl;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Employee;


/**
 *
 * @author fedec
 */
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }
    
}
