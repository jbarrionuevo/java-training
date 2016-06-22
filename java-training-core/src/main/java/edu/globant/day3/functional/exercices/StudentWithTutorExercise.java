package edu.globant.day3.functional.exercices;

import static java.util.Arrays.asList;

import java.util.Comparator;
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
}

class StudentAverageComparator implements Comparator<StudentWithTutor> {

	private Double avg;

	public StudentAverageComparator(Double avg) {
		this.avg = avg;
	}

	@Override
	public int compare(StudentWithTutor o1, StudentWithTutor o2) {
		Double sAvg1 = o1.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		Double sAvg2 = o2.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble();

		if (Math.abs(avg - sAvg1) > Math.abs(avg - sAvg2)) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class StudentWithTutorExercise {
	
	public static void showStudents(List<StudentWithTutor> studentList) {
		studentList.stream()
			.forEach(s -> System.out.println(String.format("Student %s with grades %s", s.getName(), s.getGradeList())));
	}

	public static void main(String[] args) {

		Double avgMaxTutorStudents;
		StudentWithTutor maxTutor;
		List<List<StudentWithTutor>> studentAmountByTutor;
		List<StudentWithTutor> studentAverage;

		List<StudentWithTutor> studentList = asList(new StudentWithTutor("Jorge", asList(10d, 12d, 14d), "Morgan"),
				new StudentWithTutor("Magnolia", asList(19d, 7d, 2d), "Felipe"),
				new StudentWithTutor("Olinda", asList(3d, 17d, 5d), "Lucrecia"),
				new StudentWithTutor("Mauricio", asList(8d, 16d, 13d), "Adrián"),
				new StudentWithTutor("Paula", asList(12d, 11d, 4d), "Morgan"),
				new StudentWithTutor("Fabricio", asList(5d, 18d, 10d), "Morgan"),
				new StudentWithTutor("Beatriz", asList(9d, 17d, 14d), "Adrián"),
				new StudentWithTutor("Jacob", asList(20d, 2d, 7d), "Felipe"));

		List<StudentWithTutor> studentsWithHigherGrade = studentList.stream()
				.sorted((a, b) -> Double.compare(
						b.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble(),
						a.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble()))
				.limit(3).collect(Collectors.toList());
		System.out.println("----------------------------------------------------------------");
		List<StudentWithTutor> studentsWithLowerGrade = studentList.stream()
				.sorted((a, b) -> Double.compare(
						a.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble(),
						b.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble()))
				.limit(3).collect(Collectors.toList());
		System.out.println("Students with higher grade: ");
		showStudents(studentsWithHigherGrade);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Students with lower grade: ");
		showStudents(studentsWithLowerGrade);

		Double classAverage = studentList.stream().flatMap(s -> s.getGradeList().stream())
				.mapToDouble(Double::doubleValue).average().orElse(10d);
		StudentAverageComparator cmp = new StudentAverageComparator(classAverage);

		studentAverage = studentList.stream().sorted((a, b) -> cmp.compare(a, b)).limit(1).collect(Collectors.toList());
		System.out.println("----------------------------------------------------------------");
		System.out.println("Student closest to average: ");
		showStudents(studentAverage);

		studentAmountByTutor = studentList.stream().collect(Collectors.groupingBy(StudentWithTutor::getTutor))
				.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());

		List<StudentWithTutor> maxTutorStudents = studentAmountByTutor.stream()
				.sorted((List<StudentWithTutor> a, List<StudentWithTutor> b) -> (a.size() > b.size()) ? -1 : 1).limit(1)
				.collect(Collectors.toList()).get(0);

		avgMaxTutorStudents = maxTutorStudents.stream().flatMap(s -> s.getGradeList().stream()).mapToDouble(Double::doubleValue).average().getAsDouble();
		maxTutor = maxTutorStudents.stream().limit(1).collect(Collectors.toList()).get(0);
		System.out.println("----------------------------------------------------------------");
		System.out.println("The tutor with most students is " + maxTutor.getTutor() + " and the average is " + avgMaxTutorStudents);
		
	}
	

}
