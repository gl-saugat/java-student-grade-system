package gradingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Management management = new Management();
//
//        management.addStudent("Saugat", 45);
//        management.addStudent("Saugat2", 65);
//        management.addStudent("Saugat23", 98);
//
//        management.listAllStudents();
//
//        System.out.println(management.topStudent());
//
//        System.out.println(management.averageGrade());
//
//        management.passedStudents().forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        Management management = new Management();
        UserInterface ui = new UserInterface(scanner, management);
        ui.start();
    }
}