package edu.globant.day3.functional.exercises;

import static java.util.Arrays.asList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.globant.day1.constructors.Student;

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
		return this.getGradeList().stream().mapToDouble(Double::doubleValue)
				.average().orElse(0);
	}
	
	public String toString(){
		return "Student: "+this.name+" - Tutor: "+this.tutor;	
	}

}

public class StreamsDemo {

	public static void main(String[] args) {
		List<StudentWithTutor> studentList = asList(
				new StudentWithTutor("Magnolia", asList(9d, 9d, 9d), "Felipe"),
				new StudentWithTutor("Dante", asList(10d, 10d, 25d), "Morgan"),
				new StudentWithTutor("Olinda", asList(8.53d, 8.53d, 8.53d), "Lucrecia"),
				new StudentWithTutor("Mauricio", asList(4d, 5d, 6d), "Adrián"),
				new StudentWithTutor("Paula", asList(10d, 10d, 12d), "Morgan"));

		Double classAverageGrade = studentList.stream()
				.flatMap(s -> s.getGradeList().stream())
				.mapToDouble(Double::doubleValue).average().orElse(10d);

		showStudents(showTop3StudentsFromAverage(studentList));
		showStudents(showLowest3StudentsFromAverage(studentList));
		showStudent(studentClosestToAverageClass(studentList, classAverageGrade));
		System.out.println("tutorWithMostStudents");
		System.out.println(tutorWithMostStudents(studentList));
		System.out.println("\n");
		System.out.println(bestStudentOfTutor(studentList));

	}

	public static void showStudent(StudentWithTutor student) {
		System.out.println(String.format("Student %s with grades %s",
				student.getName(), student.getGradeList()));
		System.out.println("\n");
	}

	public static void showStudents(List<StudentWithTutor> studentList) {
		studentList.stream().forEach(
				s -> System.out.println(String.format(
						"Student %s with grades %s", s.getName(),
						s.getGradeList())));
		System.out.println("\n");
	}

	public static List<StudentWithTutor> showTop3StudentsFromAverage(
			List<StudentWithTutor> studentList) {
		System.out.println("Top 3 from average");
		return studentList.stream()
				.sorted((s1, s2) -> Double.compare(s2.average(), s1.average()))
				.limit(3)
				.collect(Collectors.toList());
	}

	public static List<StudentWithTutor> showLowest3StudentsFromAverage(
			List<StudentWithTutor> studentList) {
		System.out.println("Lowest 3 from average");
		return studentList.stream()
				.sorted((s1, s2) -> Double.compare(s1.average(), s2.average()))
				.limit(3).collect(Collectors.toList());
	}

	public static StudentWithTutor studentClosestToAverageClass(List<StudentWithTutor> studentList, double averageClass) {
		System.out.println("studentClosestToAverageClass -> Average class: "
				+ averageClass);
		return studentList
				.stream()
				.sorted((s1,s2) -> Double.compare(Math.abs(s1.average() - averageClass), Math.abs(s2.average() - averageClass)))
				.limit(1)
				.collect(Collectors.toList()).get(0);
	}
	
	public static String tutorWithMostStudents(List<StudentWithTutor> studentList) {
		return studentList
				.stream()
				.collect(Collectors.groupingBy(StudentWithTutor::getTutor))
				.entrySet()
				.stream()
				.map(tut -> tut.getKey())
				.collect(Collectors.toList()).get(0).toString();
	}
	
	public static String bestStudentOfTutor(List<StudentWithTutor> studentList) {
		String tutorWithMostStudents = tutorWithMostStudents(studentList);
		System.out.println("bestStudentOfTutorWithMostStudents: "+tutorWithMostStudents);
		return studentList
				.stream()
				.filter(s -> s.getTutor().equals(tutorWithMostStudents))
				.sorted((s1, s2) -> Double.compare(s2.average(), s1.average()))
				.map(s -> s.getName())
				.limit(1)
				.collect(Collectors.toList()).get(0).toString();
	}

}
