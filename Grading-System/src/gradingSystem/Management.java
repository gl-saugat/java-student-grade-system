package gradingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Management {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Double> scores = new ArrayList<>();

    public void addStudent(String name, double score){
        this.students.add(new Student(name, score));
        this.scores.add(score);
    }

    public void listAllStudents(){
        this.students.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .forEach(System.out::println);
    }

    public void averageGrade(){
        double average = scores.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        System.out.println(average);
    }

    public void topStudent(){
        Optional<Student> topStudent = this.students.stream()
                .max(Comparator.comparingDouble(Student::getScore));

        topStudent.ifPresent(System.out::println);

    }

    public void passedStudents(){
        this.students.stream()
                .filter(student -> student.getScore() >= 50)
                .forEach(System.out::println);
    }




}
