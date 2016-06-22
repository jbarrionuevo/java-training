package edu.globant.day3.functional.exercises;

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

	public String getTutor() {
		return tutor;
	}
	
	public double average(){
		return this.getGradeList().stream().mapToDouble(Double::doubleValue).average().orElse(0);
	}

	@Override
	public String toString(){
		return String.format("%s average's: %.2f", this.getName(), this.average());
	}
}

public class StudentWithTutorDemo {

	public static List<StudentWithTutor> topAvgGrade(List<StudentWithTutor> studentList) {
		return studentList.stream()
				.sorted((s1,s2)-> s1.average() > s2.average() ? -1 : 1).limit(3).collect(Collectors.toList());						
	}
	
	public static List<StudentWithTutor> lowestAvgGrade(List<StudentWithTutor> studentList) {
		return studentList.stream()
				.sorted((s1,s2)-> s1.average() < s2.average() ? -1 : 1).limit(3).collect(Collectors.toList());						
	}
	
	private static StudentWithTutor closetoAvg(List<StudentWithTutor> studentList) {
		double classAvg = studentList.stream().mapToDouble((s)->s.average()).summaryStatistics().getAverage();
		return studentList.stream()
				.sorted((s1,s2)-> Math.abs(s1.average() - classAvg) > Math.abs(s2.average() - classAvg) ? 1 : -1)
				.collect(Collectors.toList()).get(0);
	}
	
	public static String tutorWithMostS(List<StudentWithTutor> studentList){
		return studentList.stream()
				.collect(Collectors.groupingBy(StudentWithTutor::getTutor))
				.entrySet().stream()
				.map(t->t.getKey()).collect(Collectors.toList()).get(0).toString();
	}
	
	public static String tutorBestS(List<StudentWithTutor> studentList){
		String tutWMS = tutorWithMostS(studentList);
		return studentList.stream()
				.filter(s->s.getTutor().equals(tutWMS))
				.sorted((s1, s2) -> s1.average() > s2.average() ?  -1 : 1)
				.collect(Collectors.toList()).get(0).toString();
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
		System.out.println("------------------------------------");
		System.out.println("Top 3 averages: ");
		showStudents(topAvgGrade(studentList));
		System.out.println("------------------------------------");
		System.out.println("Lowest 3 averages: ");
		showStudents(lowestAvgGrade(studentList));
		System.out.println("------------------------------------");
		System.out.println("Worst avg grade close to avg class: ");
		System.out.println(closetoAvg(studentList));
		System.out.println("------------------------------------");
		String tutor = tutorWithMostS(studentList);
		System.out.println("Tutor with most students: "+tutor);
		System.out.println(tutor+" best student: ");
		System.out.println(tutorBestS(studentList));	
	}

	public static void showStudents(List<StudentWithTutor> studentList) {
		studentList.stream().forEach(s -> System.out.println(String.format("Student %s with grades %s", s.getName(), s.getGradeList())));
	}
	
}