package gradingSystem;

import java.util.Scanner;

public class UserInterface {
    Scanner scan;
    Management logic;
    public UserInterface(Scanner scanner, Management logic){
        this.scan = scanner;
        this.logic = logic;
    }

    public void start(){
        boolean run = true;
        while(run){
            printMenu();
            int input = getMenuOption();
            if(input == 6){
                break;
            }
        }


    }

    public void printMenu(){
        System.out.println("1. Add Student\n" +
                "2. View All Students\n" +
                "3. Show Average Grade\n" +
                "4. Show Top Student\n" +
                "5. Show Passed Students\n" +
                "6. Exit");
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
}
