/*
Get the top 3 students from their average grade.
Get the lowest 3 students from their average grade.
Get the student whose average grade is closest to the average of the class. If there are two or more, choose only one of them.
Get the tutor with most students. From their students, get the student with highest grades.
 */
package edu.globant.day3.exercises.functional;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author federico.calarco
 */
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

    public double getAverage() {
        return this.getGradeList()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

}

public class StudentsApp {

    public static void main(String... args) {

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

        List<StudentWithTutor> studentsWithGradeAbove10
                = studentList.stream()
                .filter(s -> s.getGradeList().stream()
                        .mapToDouble(Double::doubleValue)
                        .average().orElse(0) > 10)
                .collect(Collectors.toList());
        showStudents(studentsWithGradeAbove10);

        showStudents(studentsWithGradeAbove10);

        System.out.println("----------------------------------------------------------");

        List<StudentWithTutor> studentsTop3 = studentList.stream()
                .limit(3)
                .collect(toList());

        showStudents(studentsTop3);

    }

    public static void showStudents(List<StudentWithTutor> studentList) {
        studentList.stream()
                .forEach(s -> System.out.println(String.format("Student %s with grades %s - average: %s" , s.getName(), s.getGradeList(), s.getAverage())));
    }

}
