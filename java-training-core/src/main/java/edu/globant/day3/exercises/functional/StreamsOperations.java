package edu.globant.day3.exercises.functional;

import static java.util.Arrays.asList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

	public String getTutor() {
		return tutor;
	}
	
	public double average() {
		return this.getGradeList().stream().mapToDouble(Double::doubleValue).average().orElse(0); 
	}
}

public class StreamsOperations {
	

	public static List<StudentWithTutor> get3BestAverages(List<StudentWithTutor> studentList){
				
		return studentList.stream().sorted((s1,s2)-> Double.compare(s2.average(), s1.average())).limit(3)
				.collect(Collectors.toList());
	}
	
	public static List<StudentWithTutor> get3WorstAverages(List<StudentWithTutor> studentList){
		
		return studentList.stream().sorted((s1,s2)-> Double.compare(s1.average(), s2.average())).limit(3)
				.collect(Collectors.toList());
	}
	
	public static StudentWithTutor getStudentClosestToClassAverage(List<StudentWithTutor> studentList){
		
		Double classAverageGrade = studentList.stream()
				.flatMap(s -> s.getGradeList().stream())
				.mapToDouble(Double::doubleValue)
				.average()
				.orElse(10d);
		return studentList.stream()
				.sorted((s1, s2) -> Math.abs(s1.average() - classAverageGrade) > 
									Math.abs(s2.average() - classAverageGrade) ? 1 : -1)
				.limit(1)
				.collect(Collectors.toList()).get(0);
	}
	
	public static String getTutorWithMostStudents(List<StudentWithTutor> studentList){
		
		return studentList.stream()
		.collect(Collectors.groupingBy(StudentWithTutor::getTutor))
		.entrySet()
		.stream()
		.sorted((t1,t2)-> Integer.compare((t2.getValue().size()), (t1.getValue().size())))
		.map(t->t.getKey())
		.collect(Collectors.toList()).get(0).toString()
		;
	}
	
	public static String getBestStudentFromTutor(List<StudentWithTutor> studentList, String tutor){
		return studentList.stream()
				.collect(Collectors.groupingBy(StudentWithTutor::getTutor))
				.entrySet()
				.stream()
				.filter(t -> t.getKey().equals(tutor))
				.collect(Collectors.toList())
				.get(0)
				.getValue()
				.stream().sorted((s1,s2) -> Double.compare(s2.average(), s1.average()))
				.collect(Collectors.toList()).get(0).getName();
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
		showStudents(studentList);
		System.out.println("----------------------------------------------------------");
		System.out.println("Best three averages:");
		showStudents(get3BestAverages(studentList));
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Worst three averages:");
		showStudents(get3WorstAverages(studentList));
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Student whose average is closest to the class average:");
		StudentWithTutor student = getStudentClosestToClassAverage(studentList);
		System.out.println(student.getName() + " with an average of " + student.average());
		System.out.println("----------------------------------------------------------");
		
		String tutorWithMostStudents = getTutorWithMostStudents(studentList);
		System.out.println("Tutor with most students is: " + tutorWithMostStudents);
		System.out.println("And tutor's best student is: " + getBestStudentFromTutor(studentList, tutorWithMostStudents));
		System.out.println("----------------------------------------------------------");
		
				
		
		
		List<StudentWithTutor> studentsWithGradeAbove10 =
			studentList.stream()
				.filter(s -> s.getGradeList().stream()
						.mapToDouble(Double::doubleValue)
						.average().orElse(0) > 10)
				.collect(Collectors.toList());
		showStudents(studentsWithGradeAbove10);
		System.out.println("----------------------------------------------------------");
		Map<String, List<StudentWithTutor>> studentsByTutor =
				studentList.stream()
					.collect(Collectors.groupingBy(StudentWithTutor::getTutor));
		studentsByTutor.entrySet().stream()
			.forEach(e -> { 
				System.out.println(e.getKey() + "'s students: ");
				showStudents(e.getValue());
			});
		System.out.println("----------------------------------------------------------");
		Map<String, List<StudentWithTutor>> studentsByTutorOrdered =
				studentList.stream()
					.collect(Collectors.groupingBy(
							StudentWithTutor::getTutor,
							LinkedHashMap::new,
							Collectors.toList()));
		studentsByTutorOrdered.entrySet().stream()
			.forEach(e -> { 
				System.out.println(e.getKey() + "'s students: ");
				showStudents(e.getValue());
			});
		System.out.println("----------------------------------------------------------");
		Double classAverageGrade = studentList.stream()
			.flatMap(s -> s.getGradeList().stream())
			.mapToDouble(Double::doubleValue)
			.average()
			.orElse(10d);
		System.out.println(String.format("Class average grade is %.2f.", classAverageGrade));
	}

	public static void showStudents(List<StudentWithTutor> studentList) {
		studentList.stream()
			.forEach(s -> System.out.println(String.format("Student %s with grades %s", s.getName(), s.getGradeList())));
	}
}
