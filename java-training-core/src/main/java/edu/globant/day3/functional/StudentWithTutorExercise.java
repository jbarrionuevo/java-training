package edu.globant.day3.functional;

import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class StudentAverageComparator implements Comparator {

	private StudentWithTutor studentAverage = null;
	private Double avg;

	public StudentAverageComparator(Double avg) {
		this.avg = avg;
	}
	
	public boolean compareAverage(StudentWithTutor o1) {
		Double s1Avg, s2Avg;
		
		if(studentAverage == null) {
			studentAverage = o1;
			
			return true;
		} else {
			s1Avg = o1.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
			s2Avg = studentAverage.getGradeList().stream().mapToDouble(Double::doubleValue).average().getAsDouble();

			if(Math.abs(avg - s1Avg) < Math.abs(avg - s2Avg)) {
				this.studentAverage = o1;
				return true;
			}
			
			return false;
		}

	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class StudentWithTutorExercise {

	public static void main(String[] args) {

		List<StudentWithTutor> studentAverage;

		List<StudentWithTutor> studentList = asList(
				new StudentWithTutor("Jorge", asList(10d, 12d, 14d), "Morgan"),
				new StudentWithTutor("Magnolia", asList(19d, 7d, 2d), "Felipe"),
				new StudentWithTutor("Olinda", asList(3d, 17d, 5d), "Lucrecia"),
				new StudentWithTutor("Mauricio", asList(8d, 16d, 13d), "Adrián"),
				new StudentWithTutor("Paula", asList(12d, 11d, 4d), "Morgan"),
				new StudentWithTutor("Fabricio", asList(5d, 18d, 10d), "Morgan"),
				new StudentWithTutor("Beatriz", asList(9d, 17d, 14d), "Adrián"),
				new StudentWithTutor("Jacob", asList(20d, 2d, 7d), "Felipe"));

		StreamsDemo.showStudents(studentList);
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
		StreamsDemo.showStudents(studentsWithHigherGrade);
		System.out.println("----------------------------------------------------------------");
		StreamsDemo.showStudents(studentsWithLowerGrade);

//		Double classAverage = studentList.stream().flatMap(s -> s.getGradeList().stream())
//				.mapToDouble(Double::doubleValue).average().orElse(10d);
//		StudentAverageComparator cmp = new StudentAverageComparator(classAverage);
//		
//		studentAverage = studentList.stream().filter(s -> cmp.compareAverage(s)).collect(Collectors.toList());
//		
//		StreamsDemo.showStudents(studentAverage);
		
		

	}
}
