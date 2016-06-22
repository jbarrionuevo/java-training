package edu.globant.day3.multithreading.exercises;

public class Task{
	private TypeOfTask typeOfTask;
	
	public Task(TypeOfTask type){
		this.typeOfTask = type;
	}

	public TypeOfTask getTypeOfTask() {
		return typeOfTask;
	}

	public void setTypeOfTask(TypeOfTask typeOfTask) {
		this.typeOfTask = typeOfTask;
	}
	
}
