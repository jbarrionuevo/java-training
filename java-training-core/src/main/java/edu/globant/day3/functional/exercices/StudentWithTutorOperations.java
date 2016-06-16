package edu.globant.day3.functional.exercices;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.stream.Collectors;


class StudentWithTutor {
	private final String name;
	private final List<Double> gradeList;
	private final String tutor;

	public StudentWithTutor(String name, List<Double> gradeList, String tutor) {
		this.name = name;
		this.gradeList = gradeList;
		this.tutor = tutor;
	}

	public String getName() {
		return name;
	}

	public List<Double> getGradeList() {
		return gradeList;
	}
	
	public double average(){
		return this.gradeList.stream().mapToDouble(Double::doubleValue).reduce(0, (a,b)->a+b) / this.gradeList.size();
	}

	@Override
	public String toString(){
		return String.format("%s with average: %.2f", this.getName(), this.average());
	}
	
	public String getTutor() {
		return tutor;
	}
}

public class StudentWithTutorOperations {
	
	public static List<StudentWithTutor> get3Averages(List<StudentWithTutor> studentList, boolean up){
		return studentList.stream()
				.sorted((s1, s2) -> 
					s1.getGradeList().stream().mapToDouble(Double::doubleValue).average().orElse(0)  > 
					s2.getGradeList().stream().mapToDouble(Double::doubleValue).average().orElse(0) ? up ? -1 : 1 
																								    : up ? 1 : -1)
				.limit(3)
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<StudentWithTutor> studentList = asList(
				new StudentWithTutor("Jorge", asList(10d, 12d, 14d), "Morgan"),
				new StudentWithTutor("Magnolia", asList(19d, 7d, 2d), "Felipe"),
				new StudentWithTutor("Olinda", asList(3d, 17d, 5d), "Lucrecia"),
				new StudentWithTutor("Mauricio", asList(8d, 16d, 13d), "Adrián"),
				new StudentWithTutor("Paula", asList(12d, 11d, 4d), "Morgan"),
				new StudentWithTutor("Fabricio", asList(5d, 18d, 10d), "Morgan"),
				new StudentWithTutor("Beatriz", asList(9d, 17d, 14d), "Adrián"),
				new StudentWithTutor("Jacob", asList(20d, 2d, 7d), "Felipe")
				);
		
		System.out.println(studentList);
		System.out.println("Best 3 averages: ");
		System.out.println(get3Averages(studentList,true));
		System.out.println("Worst 3 averages: ");
		System.out.println(get3Averages(studentList,false));
	}
}
