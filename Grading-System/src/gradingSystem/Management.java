package gradingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Management {
    ArrayList<Student> students = new ArrayList<>();


    public void addStudent(String name, double score){
        this.students.add(new Student(name, score));
    }

    public void listAllStudents(){
        this.students.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .forEach(student -> System.out.println(student + " -> "+ student.assignGrade()));
    }

    public double averageScore(){
        return this.students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0);
    }

    public Student topStudent(){
        return this.students.stream()
                .max(Comparator.comparingDouble(Student::getScore))
                .orElse(new Student("default", 0));
    }

    public List<Student> passedStudents(){
        return this.students.stream()
                .filter(student -> student.getScore() >= 50)
                .toList();
    }





}
