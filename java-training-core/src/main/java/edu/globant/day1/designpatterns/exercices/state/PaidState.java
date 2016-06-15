package edu.globant.day1.designpatterns.exercices.state;

public class PaidState implements SaleState{

	@Override
	public String printStatus() {
		// TODO Auto-generated method stub
		return "The sale has been paid";
	}

}
