package gradingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .forEach(student -> System.out.println(student + " -> "+ assignGrade(student)));
    }

    public double averageScore(){
        return scores.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    public Student topStudent(){
        return this.students.stream()
                .max(Comparator.comparingDouble(Student::getScore))
                .orElse(new Student("default", 0));
    }

    public ArrayList<Student> passedStudents(){
        return this.students.stream()
                .filter(student -> student.getScore() >= 50)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Grades assignGrade(Student student){
        double marks = student.getScore();
        if (marks >= 90) return Grades.A;
        else if (marks >= 80) return Grades.B;
        else if (marks >= 70) return Grades.C;
        else if (marks >= 50) return Grades.D;
        else return Grades.FAIL;
    }




}
