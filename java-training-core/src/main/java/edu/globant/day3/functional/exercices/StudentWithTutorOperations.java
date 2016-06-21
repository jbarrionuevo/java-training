package edu.globant.day3.functional.exercices;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;
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
		return this.getGradeList().stream().mapToDouble(Double::doubleValue).average().orElse(0);
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
	
	public static List<StudentWithTutor> get3Averages(List<StudentWithTutor> studentList, boolean descending){ 
		//descending determines the order (false->ascending) of the averages
		return studentList.stream()
				.sorted((s1, s2) -> 
					s1.average()  > s2.average() ? descending ? -1 : 1 
												 : descending ? 1 : -1)
				.limit(3)
				.collect(Collectors.toList());
	}
	
	public static StudentWithTutor getClosestStudentToAverage(List<StudentWithTutor> studentList){
		//Get the student whose average grade is closest to the average of the class. If there are two or more, choose only one of them
		double classAverage = 
				studentList.stream()
					.map(s->s.average()).collect(Collectors.toList())
					.stream()
					.mapToDouble(Double::doubleValue)
					.average().orElse(0);
		return studentList.stream()
				.sorted((s1, s2) -> Math.abs(s1.average() - classAverage) > 
									Math.abs(s2.average() - classAverage) ? 1 : -1)
				.limit(1)
				.collect(Collectors.toList()).get(0);
	}
	
	public static String tutorWithMoreStudents(List<StudentWithTutor> studentList){
		//Get the tutor with most students. 
		return studentList.stream()
		.collect(Collectors.groupingBy(StudentWithTutor::getTutor))
		.entrySet()
		.stream()
		.sorted((t1,t2)->t1.getValue().size() > t2.getValue().size() ? -1 : 1)
		.map(t->t.getKey())
		.collect(Collectors.toList()).get(0).toString()
		;
	}
	
	public static String bestStudentOfTutor(List<StudentWithTutor> studentList, String tutor){
		//From tutor students, get the student with highest grades.
		return ((List<StudentWithTutor>)studentList.stream()
				.collect(Collectors.groupingBy(StudentWithTutor::getTutor))
				.entrySet()
				.stream()
				.filter(t->t.getKey().equals(tutor))
				.collect(Collectors.toList())
				.get(0)
				.getValue())
				.stream()
				.sorted((s1, s2) -> 
						s1.average()  > s2.average() ?  -1 : 1)
				.collect(Collectors.toList()).get(0)
				.toString()
		;
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
		System.out.println("Closest student to class average: ");
		System.out.println(getClosestStudentToAverage(studentList));
		String tutor = tutorWithMoreStudents(studentList);
		System.out.println("Tutor with most students: ");
		System.out.println(tutor);
		System.out.println("Best student from that Tutor: ");
		System.out.println(bestStudentOfTutor(studentList,tutor));

	}
}
