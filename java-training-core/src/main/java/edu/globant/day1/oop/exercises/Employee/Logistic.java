package edu.globant.day1.oop.exercises.Employee;

import java.util.Observable;
import java.util.Observer;

public class Logistic implements TypeOfEmployee,Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(arg1);		
		System.out.println("Logistic observer");
	}
}
