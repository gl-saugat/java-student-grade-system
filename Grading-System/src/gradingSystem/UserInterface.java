package gradingSystem;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class UserInterface {
    Scanner scan;
    Management logic;
    public UserInterface(Scanner scanner, Management logic){
        this.scan = scanner;
        this.logic = logic;
    }

    public void start(){
        while(true){
            printMenu();
            int input = getMenuOption();
            switch (input){
                case 1:
                    String name = getName();
                    double score = getScore();
                    logic.addStudent(name, score );
                    break;
                case 2:
                    logic.listAllStudents();
                    break;
                case 3:
                    OptionalDouble average = logic.averageScore();
                    if(average.isPresent()){
                        System.out.printf("Average score is: %.2f.\n", average.getAsDouble());
                    }else{
                        System.out.println("No students available.");
                    }
                    break;
                case 4:
                    Optional<Student> top = logic.topStudent();
                    top.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("No students to compare.")
                    );
                    break;
                case 5:
                    List<Student> passed = logic.passedStudents();
                    if(passed.isEmpty()){
                        System.out.println("No passed marks yet!.");
                    }else{
                        passed.forEach(System.out::println);
                    }

                case 6:
                    return;
            }

        }


    }

    public void printMenu(){
        System.out.println();
        System.out.println("""
                1. Add Student
                2. View All Students
                3. Show Average Grade
                4. Show Top Student
                5. Show Passed Students
                6. Exit""");
    }

    public int getMenuOption(){
         int input = 0;
        while(true){
            try{
                input = Integer.parseInt(scan.nextLine());
                if(input > 0 && input <=6){
                    return input;
                }
                System.out.println("Please enter a valid option.");
            }catch (Exception e){
                System.out.println("Error, incorrect input :" + e.getMessage());
            }
        }
    }

    public String getName(){
        String input = "";
        while (true){
            try{
                System.out.print("Enter name: ");
                input = scan.nextLine();
                if(!(input.isEmpty())){
                    return input;
                }
                System.out.println("Cannot leave the field empty.");
            }catch (Exception e){
                System.out.println("Error is " + e.getMessage());
            }
        }

    }


    public double getScore(){
        double input = 0;
        while (true){
            try{
                System.out.print("Enter scores attained: ");
                input = Double.parseDouble(scan.nextLine());
                if(input >= 0 && input <=100){
                    return input;
                }
                System.out.println("Simple Maths: 0-100 !");
            }catch (Exception e){
                System.out.println("Error is " + e.getMessage());
            }
        }

    }
}
