package gradingSystem;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Management management = new Management();
    static UserInterface ui = new UserInterface(scanner, management);
    public static void main(String[] args) {
        ui.start();
    }
}