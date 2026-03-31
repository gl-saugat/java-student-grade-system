package gradingSystem;

import java.util.*;
import java.util.stream.Collectors;

public class Management {
    ArrayList<Student> students = new ArrayList<>();


    public void addStudent(String name, double score){
        this.students.add(new Student(name, score));
    }

    public void listAllStudents(){
        if(this.students.isEmpty()){
            System.out.println("No students are enrolled yet.");
        }else{
            this.students.stream()
                    .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                    .forEach(student -> System.out.println(student + " -> "+ student.assignGrade()));
        }
    }

    public OptionalDouble averageScore(){
        return this.students.stream()
                .mapToDouble(Student::getScore)
                .average();
    }

    public Optional<Student> topStudent(){
        return this.students.stream()
                .max(Comparator.comparingDouble(Student::getScore));
    }

    public List<Student> passedStudents(){
        return this.students.stream()
                .filter(student -> student.getScore() >= 50)
                .toList();
    }

}
